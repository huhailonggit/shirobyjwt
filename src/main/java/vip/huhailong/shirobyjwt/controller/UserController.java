package vip.huhailong.shirobyjwt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.entity.UserInfo;
import vip.huhailong.shirobyjwt.enums.ResEnum;
import vip.huhailong.shirobyjwt.service.IUserInfoService;
import vip.huhailong.shirobyjwt.service.IUserService;
import vip.huhailong.shirobyjwt.util.JwtUtil;
import vip.huhailong.shirobyjwt.util.ResUtil;
import vip.huhailong.shirobyjwt.util.SendMailUtil;
import vip.huhailong.shirobyjwt.util.TimeUtil;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserInfoService infoService;
    @Autowired
    SendMailUtil mailUtil;
    @Value("${server-mail.host}")
    private String enableUrl;

    @Transactional
    @PostMapping("/register")
    public ResEntity register(@RequestBody User user) throws MessagingException {
        int userCount = userService.count(new QueryWrapper<User>().eq("username", user.getUsername()));
        int mailCount = userService.count(new QueryWrapper<User>().eq("enable_mail", user.getEnableMail()));
        if(userCount>0){
            return ResUtil.error(ResEnum.SYSTEM_ERROR.getCode(),"用户名已存在");
        }
        if(mailCount>0){
            return ResUtil.error(ResEnum.SYSTEM_ERROR.getCode(),"改邮箱已绑定");
        }
        user.setCreateTime(TimeUtil.getDateTime());
        user.setEnable(false);
        user.setLocked(false);
        user.setExpire(false);
        String hashPassword = new SimpleHash(Sha256Hash.ALGORITHM_NAME,user.getPassword(), ByteSource.Util.bytes(user.getUsername()),16).toBase64();
        user.setPassword(hashPassword);
        userService.save(user);
        userService.initUserRole(user);
        String sign = JwtUtil.sign(user.getUsername(), hashPassword);
        String html = "<!DOCTYPE html><html><head>\t<title>邮箱验证</title>\t<style>\t\t.box{\t\t\ttext-align: center;\t\t}\t\timg{\t\t\twidth:20%;\t\t}\t</style></head><body>\t<div class=\"box\">\t\t<h3>欢迎注册<a href=\"https://www.huhailong.vip\">huhailong.vip</a></h3>\t\t<img src=\"https://www.huhailong.vip/img/wx.jpg\"><br>\t\t<p>点击下面的链接进行验证注册，如果过期请重新注册</p>\t\t<a href=\""+enableUrl+sign+"\"><b>点击这里进行验证</b></a>\t\t</div></body></html>";
        mailUtil.sendSimpleMail(user.getEnableMail(),"Huhailong-注册验证信息",html);
        return ResUtil.success(null,"注册成功");
    }

    @GetMapping("/getUserInfoOne")
    @RequiresRoles({"user"})
    public ResEntity getUserInfoOne(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        return ResUtil.success(userService.getUserByUsername(JwtUtil.getUsername(token)),"获取成功");
    }

    @GetMapping("/getUserInfo")
    @RequiresRoles("user")
    public ResEntity getUserInfo(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        User user = userService.getUserByUsername(JwtUtil.getUsername(token));
        UserInfo info = infoService.getOne(new QueryWrapper<UserInfo>().eq("user_id",user.getId()));
        return ResUtil.success(info,"获取用户信息成功");
    }
}
