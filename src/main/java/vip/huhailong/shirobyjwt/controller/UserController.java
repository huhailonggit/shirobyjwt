package vip.huhailong.shirobyjwt.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.service.IUserService;
import vip.huhailong.shirobyjwt.util.ResUtil;
import vip.huhailong.shirobyjwt.util.SendMailUtil;
import vip.huhailong.shirobyjwt.util.TimeUtil;

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
    SendMailUtil mailUtil;

    @PostMapping("/register")
    public ResEntity register(@RequestBody User user){
        user.setCreateTime(TimeUtil.getDateTime());
        user.setEnable(false);
        user.setLocked(true);
        user.setExpire(false);
        String hashPassword = new SimpleHash(Sha256Hash.ALGORITHM_NAME,user.getPassword(), ByteSource.Util.bytes(user.getUsername()),16).toBase64();
        user.setPassword(hashPassword);
        userService.save(user);
        mailUtil.sendSimpleMail(user.getEnableMail());
        return ResUtil.success(null,"注册成功");
    }

    @GetMapping("/getUserInfoOne")
    @RequiresRoles({"user","admin"})
    public ResEntity getUserInfoOne(String username){
        return ResUtil.success(userService.getUserByUsername(username),"获取成功");
    }
}
