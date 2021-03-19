package vip.huhailong.shirobyjwt.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.huhailong.shirobyjwt.config.shiro.AccountEnableException;
import vip.huhailong.shirobyjwt.config.shiro.ExpireException;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.enums.ResEnum;
import vip.huhailong.shirobyjwt.service.IUserService;
import vip.huhailong.shirobyjwt.util.JwtUtil;
import vip.huhailong.shirobyjwt.util.ResUtil;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@RestController
public class ShiroController {

    @Autowired
    IUserService userService;

    @PostMapping("/login")
    public ResEntity login(String username, String password) {
        User user = userService.getUserByUsername(username);
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
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(), "用户未激活");
        }
        //登录成功生成token
        String sign = JwtUtil.sign(username, password);//这里暂时把盐值设置未用户名，后期会在注册时候生成一个对应的值
        return ResUtil.success(sign, "登录成功");
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
