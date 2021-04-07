package vip.huhailong.shirobyjwt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.entity.UserInfo;
import vip.huhailong.shirobyjwt.entity.vo.UserRoleVO;
import vip.huhailong.shirobyjwt.enums.ResEnum;
import vip.huhailong.shirobyjwt.service.IUserInfoService;
import vip.huhailong.shirobyjwt.service.IUserService;
import vip.huhailong.shirobyjwt.util.JwtUtil;
import vip.huhailong.shirobyjwt.util.ResUtil;
import vip.huhailong.shirobyjwt.util.SendMailUtil;
import vip.huhailong.shirobyjwt.util.TimeUtil;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author Huhailong
 * @Description user controller
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
            return ResUtil.error(ResEnum.SYSTEM_ERROR,"用户名已存在");
        }
        if(mailCount>0){
            return ResUtil.error(ResEnum.SYSTEM_ERROR,"改邮箱已绑定");
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
        System.out.println("注册成功");
        return ResUtil.success(null,"注册成功，请前往邮箱激活");
    }

    @GetMapping("/getUserInfoOne")
    @RequiresRoles({"user"})
    public ResEntity getUserInfoOne(){
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        return ResUtil.success(userService.getUserByUsername(JwtUtil.getUsername(token)),"获取成功");
    }

    @GetMapping("/getUserInfo")
    @RequiresRoles("user")
    public ResEntity getUserInfo(){
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getUserByUsername(JwtUtil.getUsername(token));
        UserInfo info = infoService.getOne(new QueryWrapper<UserInfo>().eq("user_id",user.getId()));
        return ResUtil.success(info,"获取用户信息成功");
    }

    @PostMapping("/updatePassword")
    public ResEntity updatePassword(@RequestBody Map<String,String> map){
        String oldPassword = map.get("oldPassword");
        String newPassword = map.get("newPassword");
        if(oldPassword.isEmpty()||newPassword.isEmpty()){
            return ResUtil.error(ResEnum.SYSTEM_ERROR,"密码不能为空");
        }
        String username = JwtUtil.getUsername(SecurityUtils.getSubject().getPrincipal().toString());
        User user = userService.getUserByUsername(username);
        if(username==null||user==null){
            return ResUtil.error(ResEnum.UNAUTHORIZED,"token验证失败");
        }
        String oldHashPassword = new SimpleHash(Sha256Hash.ALGORITHM_NAME,oldPassword, ByteSource.Util.bytes(user.getUsername()),16).toBase64();
        String currentPassword = user.getPassword();
        if(oldHashPassword.equals(currentPassword)){
            String newHashPassword = new SimpleHash(Sha256Hash.ALGORITHM_NAME, newPassword, ByteSource.Util.bytes(user.getUsername()), 16).toBase64();
            user.setPassword(newHashPassword);
            userService.updateById(user);
            return ResUtil.success(null,"更新密码成功，请重新登录");
        }else{
            return ResUtil.error(ResEnum.UNAUTHORIZED,"旧密码输入有误");
        }
    }

    @PostMapping("/lockedUsers")
    public ResEntity lockedUsers(@RequestBody List<String> userIds){
        userService.update(new UpdateWrapper<User>().in("id",userIds).set("locked",1));
        return ResUtil.success(null,"更新成功");
    }

    @PostMapping("/unLockedUsers")
    public ResEntity unLockedUsers(@RequestBody List<String> userIds){
        userService.update(new UpdateWrapper<User>().in("id",userIds).set("locked",0));
        return ResUtil.success(null,"更新成功");
    }

    @PostMapping("/deleteUsers")
    public ResEntity deleteUsers(@RequestBody List<String> userIds){
        userService.update(new UpdateWrapper<User>().in("id",userIds).set("expire",1)); //逻辑删除
        return ResUtil.success(null,"删除成功");
    }

    @PostMapping("/findBackUsers")
    public ResEntity findBackUsers(@RequestBody List<String> userIds){
        userService.update(new UpdateWrapper<User>().in("id",userIds).set("expire",0)); //恢复用户
        return ResUtil.success(null,"恢复成功");
    }

    @GetMapping("/getExpireUserList")
    public ResEntity getExpireUserList(){
        List<User> expireUser = userService.list(new QueryWrapper<User>().select("id","username","enable_mail").eq("expire", 1));
        return ResUtil.success(expireUser,"查询成功");
    }

    @GetMapping("/getRoleByUserId")
    public ResEntity getRoleByUserId(String userId) {
        return ResUtil.success(userService.getRoleListByUserId(userId),"查询角色成功");
    }

    @PostMapping("/addRole")
    public ResEntity addRole(@RequestBody Map<String,String> map){
        String userId = map.get("userId");
        String roleId = map.get("roleId");
        return ResUtil.success(userService.addRole(userId,roleId),"添加成功");
    }

    @PostMapping("/delRole")
    public ResEntity delRole(@RequestBody UserRoleVO vo){
        String userId = vo.getUserId();
        List<String> roleIds = vo.getRoleIds();
        return ResUtil.success(userService.delRole(userId,roleIds),"删除成功");
    }


}
