package vip.huhailong.shirobyjwt.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.wf.captcha.GifCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.enums.ResEnum;
import vip.huhailong.shirobyjwt.service.IUserService;
import vip.huhailong.shirobyjwt.util.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@RestController
public class ShiroController {

    @Autowired
    IUserService userService;
    @Autowired
    SendMailUtil mailUtil;
    @Autowired
    RedisUtil redisUtil;
    @Value("${server-mail.host}")
    private String enableUrl;
    @Value("${server-mail.url}")
    private String url;

    @PostMapping("/login")
    public ResEntity login(String username, String password, String verCode, String verKey) throws MessagingException {
        if(!redisUtil.exitsKey(verKey)){
            return ResUtil.error(ResEnum.UNAUTHORIZED,"验证码已过期，点击重新获取");
        }
        if(verCode==null || !redisUtil.get(verKey).equals(verCode.trim().toLowerCase())){
            return ResUtil.error(ResEnum.UNAUTHORIZED,"验证码错误");
        }
        User user = userService.getUserByUsername(username);
        if(user == null){
            return ResUtil.error(ResEnum.UNAUTHORIZED,"用户不存在，请先注册");
        }
        String hashPassword = user.getPassword();
        password = new SimpleHash(Sha256Hash.ALGORITHM_NAME, password, ByteSource.Util.bytes(username), 16).toBase64();
        if (!hashPassword.equals(password)) {
            return ResUtil.error(ResEnum.UNAUTHORIZED, "密码错误-请重试");
        }
        if (user.getLocked()) {
            return ResUtil.error(ResEnum.UNAUTHORIZED, "用户被锁定");
        }
        if (user.getExpire()) {
            return ResUtil.error(ResEnum.UNAUTHORIZED, "用户已过期");
        }
        if (!user.getEnable()) {
            String sign = JwtUtil.sign(user.getUsername(), hashPassword);
            String html = "<!DOCTYPE html><html><head>\t<title>邮箱验证</title>\t<style>\t\t.box{\t\t\ttext-align: center;\t\t}\t\timg{\t\t\twidth:20%;\t\t}\t</style></head><body>\t<div class=\"box\">\t\t<h3>欢迎注册<a href=\"https://www.huhailong.vip\">huhailong.vip</a></h3>\t\t<img src=\"https://www.huhailong.vip/img/wx.jpg\"><br>\t\t<p>点击下面的链接进行验证注册，如果过期请重新注册</p>\t\t<a href=\""+enableUrl+sign+"\"><b>点击这里进行验证</b></a>\t\t</div></body></html>";
            mailUtil.sendSimpleMail(user.getEnableMail(),"Huhailong-注册验证信息",html);
            return ResUtil.error(ResEnum.UNAUTHORIZED, "用户未激活,激活邮件已重新发送");
        }
        //登录成功生成token
        String sign = JwtUtil.sign(username, password);//这里暂时把盐值设置未用户名，后期会在注册时候生成一个对应的值
        return ResUtil.success(sign, "登录成功");
    }

    @GetMapping
    public ResEntity loginByMail(String mail) throws MessagingException {
        String code = "1234";
        String codeToken = JwtUtil.signCode(mail, code);
        String html = "<!DOCTYPE html><html><head>\t<title>邮箱验证</title>\t<style>\t\t.box{\t\t\ttext-align: center;\t\t}\t\timg{\t\t\twidth:20%;\t\t}\t</style></head><body>\t<div class=\"box\">\t\t<h3>欢迎注册<a href=\"https://www.huhailong.vip\">huhailong.vip</a></h3>\t\t<img src=\"https://www.huhailong.vip/img/wx.jpg\"><br>\t\t<p>下面是验证码，有效期为5分钟，请在有效期内使用</p><h3>"+code+"</h3></div></body></html>";
        mailUtil.sendSimpleMail(mail,"SHIROBYJWT登录验证码",html);
        return ResUtil.success(codeToken,"邮件发送成功");
    }

//    public ResEntity checkMailLogin(String code,HttpServletRequest request){
//        String token = request.getHeader("Authorization");
//        String username = JwtUtil.getUsername(token);
//        if(username == null){
//            return ResUtil.error(ResEnum.SYSTEM_ERROR.getCode(),"邮箱验证码错误");
//        }
//        return null;
//    }

    @GetMapping("/captcha")
    public ResEntity captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        GifCaptcha specCaptcha = new GifCaptcha(130,48,5);
        String verCode = specCaptcha.text().toLowerCase();
        String key = MakeUUID.getUUID(false);
        //存入redis，设置过期时间
        redisUtil.add(key,verCode);
        Map<String,String> map = new HashMap<>();
        map.put("key",key);
        map.put("image",specCaptcha.toBase64());
        return ResUtil.success(map,"获取验证码成功");
    }

    @GetMapping("/logout")
    public ResEntity logout() {
        SecurityUtils.getSubject().logout();
        return ResUtil.success(null, "退出成功");
    }

    @RequestMapping("/401")
    public ResEntity unauthorized(){
        return ResUtil.error(ResEnum.UNAUTHORIZED,"401");
    }

    @GetMapping("/keepAlive")
    public ResEntity keepAlive(HttpServletRequest request){
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        String username = JwtUtil.getUsername(token);
        User user = userService.getUserByUsername(username);
        if(username==null||user==null){
            return ResUtil.error(ResEnum.SYSTEM_ERROR,"token过期，请重新登录");
        }
        if(!JwtUtil.verify(token,username,user.getPassword())){
            return ResUtil.error(ResEnum.SYSTEM_ERROR,"token过期，请重新登录");
        }
        String sign = JwtUtil.sign(username, user.getPassword());   //生成新的token
        return ResUtil.success(sign,"保活成功");
    }

    @GetMapping("/forgetPassword")
    public ResEntity forgetPassword(String username) throws MessagingException {
        User user = userService.getUserByUsername(username);
        if(user==null){
            return ResUtil.error(ResEnum.SYSTEM_ERROR,"账户不存在");
        }
        String uuid = MakeUUID.getUUID(false);  //获取随机码
        String sign = JwtUtil.sign(username, uuid); //生成jwt发送给邮箱
        String forgetHtml = "<!DOCTYPE html><html><head>\t<title>邮箱验证</title>\t<style>\t\t.box{\t\t\ttext-align: center;\t\t}\t\timg{\t\t\twidth:20%;\t\t}\t</style></head><body>\t<div class=\"box\">\t\t<h3>密码找回<a href=\"https://www.huhailong.vip\">huhailong.vip</a></h3>\t\t<p>点击下方的链接进行找回</p>\t\t<a href=\""+url+"/#/forgetPassword?token="+sign+"\">马上找回</a>\t\t<h3>随机码为："+uuid+"</h3></div></body></html>";
        mailUtil.sendSimpleMail(user.getEnableMail(),"Huhailong-密码找回",forgetHtml);
        return ResUtil.success(null,"邮件发送成功，请前往邮箱进行找回");
    }

    @PostMapping("/verForgetPassword")
    public ResEntity checkForgetPassword(@RequestBody Map<String,String> map){
        String token = map.get("verCode");
        String uuid = map.get("uuid");
        String password = map.get("password");
        String username = JwtUtil.getUsername(token);
        if(username==null || !JwtUtil.verify(token,username,uuid)){
            return ResUtil.error(ResEnum.SYSTEM_ERROR,"验证失败，请确认用户名或重新发送邮件");
        }
        User user = userService.getUserByUsername(username);
        String newPassword = new SimpleHash(Sha256Hash.ALGORITHM_NAME,password, ByteSource.Util.bytes(user.getUsername()),16).toBase64();
        user.setPassword(newPassword);
        userService.updateById(user);
        return ResUtil.success(null,"密码找回成功");
    }
}
