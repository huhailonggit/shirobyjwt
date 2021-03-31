package vip.huhailong.shirobyjwt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.entity.UserInfo;
import vip.huhailong.shirobyjwt.entity.vo.UserFullInfo;
import vip.huhailong.shirobyjwt.enums.ResEnum;
import vip.huhailong.shirobyjwt.service.IUserInfoService;
import vip.huhailong.shirobyjwt.service.IUserService;
import vip.huhailong.shirobyjwt.util.FileNameUtil;
import vip.huhailong.shirobyjwt.util.JwtUtil;
import vip.huhailong.shirobyjwt.util.ResUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/30.
 */
@Slf4j
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoService;
    @Autowired
    IUserService userService;
    @Value("${file.upload.path}")
    private String uploadPath;
    @Value(("${file.url}"))
    private String webUrl;  //资源网络地址

    @PostMapping("/uploadAvatar")
    public ResEntity uploadAvatar(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) throws IOException {
        if(file==null){
            return ResUtil.error(ResEnum.SYSTEM_ERROR,"上传文件为空，请选择文件上传");
        }
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        String username = JwtUtil.getUsername(token);
        User currentUser = userService.getUserByUsername(username);
        if(username==null||currentUser==null){
            return ResUtil.error(ResEnum.UNAUTHORIZED,"token非法，上传失败");
        }
        boolean verify = JwtUtil.verify(token, username, currentUser.getPassword());
        if(!verify){
            return ResUtil.error(ResEnum.UNAUTHORIZED,"token非法，上传失败");
        }
        String fileSuffix = FileNameUtil.getFileSuffix(Objects.requireNonNull(file.getOriginalFilename())); //获取文件类型
        String avatarName = currentUser.getId()+fileSuffix;
        File saveFile = new File(uploadPath+avatarName);
        log.info("save image path:"+saveFile.getPath());
        if(!saveFile.exists()){
            boolean newFile = saveFile.createNewFile();
            if(!newFile){
                ResUtil.error(ResEnum.SYSTEM_ERROR,"创建文件失败");
            }
        }
        file.transferTo(saveFile);
        userInfoService.update(new UpdateWrapper<UserInfo>().eq("user_id",currentUser.getId()).set("avatar",webUrl+avatarName));
        log.info(saveFile.getAbsolutePath());
        return ResUtil.success(webUrl+avatarName,"头像上传成功");
    }

    @GetMapping("/getUserInfo")
    @RequiresRoles("user")
    public ResEntity getUserInfo(HttpServletRequest request){
        String username = JwtUtil.getUsername(request.getHeader(HttpHeaders.AUTHORIZATION));
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username));
        if(username==null||user==null){
            return ResUtil.error(ResEnum.UNAUTHORIZED,"token验证失败");
        }
        UserFullInfo info = new UserFullInfo();
        user.setPassword("**********");
        info.setUser(user);
        info.setUserInfo(userInfoService.getOne(new QueryWrapper<UserInfo>().eq("user_id",user.getId())));
        return ResUtil.success(info,"查询成功");
    }

    @PostMapping("/updateUserInfo")
    public ResEntity updateUserInfo(@RequestBody UserInfo userInfo){
        userInfoService.updateById(userInfo);
        return ResUtil.success(null,"更新成功");
    }
}
