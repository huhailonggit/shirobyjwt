package vip.huhailong.shirobyjwt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wf.captcha.utils.CaptchaUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.enums.ResEnum;
import vip.huhailong.shirobyjwt.service.IUserService;
import vip.huhailong.shirobyjwt.util.JwtUtil;
import vip.huhailong.shirobyjwt.util.ResUtil;
import vip.huhailong.shirobyjwt.util.SendMailUtil;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;

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
    @Value("${server-mail.host}")
    private String enableUrl;

    @PostMapping("/login")
    public ResEntity login(String username, String password) throws MessagingException {
        User user = userService.getUserByUsername(username);
        if(user == null){
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(),"用户不存在，请先注册");
        }
        String hashPassword = user.getPassword();
        password = new SimpleHash(Sha256Hash.ALGORITHM_NAME, password, ByteSource.Util.bytes(username), 16).toBase64();
        if (!hashPassword.equals(password)) {
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(), "密码错误-请重试");
        }
        if (user.getLocked()) {
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(), "用户被锁定");
        }
        if (user.getExpire()) {
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(), "用户已过期");
        }
        if (!user.getEnable()) {
            String sign = JwtUtil.sign(user.getUsername(), hashPassword);
            String html = "<!DOCTYPE html><html><head>\t<title>邮箱验证</title>\t<style>\t\t.box{\t\t\ttext-align: center;\t\t}\t\timg{\t\t\twidth:20%;\t\t}\t</style></head><body>\t<div class=\"box\">\t\t<h3>欢迎注册<a href=\"https://www.huhailong.vip\">huhailong.vip</a></h3>\t\t<img src=\"https://www.huhailong.vip/img/wx.jpg\"><br>\t\t<p>点击下面的链接进行验证注册，如果过期请重新注册</p>\t\t<a href=\""+enableUrl+sign+"\"><b>点击这里进行验证</b></a>\t\t</div></body></html>";
            mailUtil.sendSimpleMail(user.getEnableMail(),"Huhailong-注册验证信息",html);
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(), "用户未激活,激活邮件已重新发送");
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
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CaptchaUtil.out(request,response);
    }

    @GetMapping("/logout")
    public ResEntity logout() {
        SecurityUtils.getSubject().logout();
        return ResUtil.success(null, "退出成功");
    }

    @RequestMapping("/401")
    public ResEntity unauthorized(){
        return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(),"401");
    }
}
