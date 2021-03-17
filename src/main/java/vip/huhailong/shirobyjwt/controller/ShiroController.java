package vip.huhailong.shirobyjwt.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.huhailong.shirobyjwt.config.shiro.AccountEnableException;
import vip.huhailong.shirobyjwt.config.shiro.ExpireException;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.enums.ResEnum;
import vip.huhailong.shirobyjwt.util.JwtUtil;
import vip.huhailong.shirobyjwt.util.ResUtil;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@RestController
public class ShiroController {

    @PostMapping("/login")
    public ResEntity login(String username, String password){
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            SecurityUtils.getSubject().login(token);
            //登录成功生成token
            String sign = JwtUtil.sign(token.getUsername(), token.getUsername());//这里暂时把盐值设置未用户名，后期会在注册时候生成一个对应的值
            return ResUtil.success(sign,"登录成功");
        } catch (UnknownAccountException e){
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(), "未注册用户");
        } catch (IncorrectCredentialsException e){
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(),"密码错误-请重试");
        } catch (LockedAccountException e){
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(),"账号被锁定");
        } catch (ExcessiveAttemptsException e){
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(),"操作频繁-请稍后在世");
        } catch (ExpireException e){
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(),"账号已过期");
        } catch (AccountEnableException e){
            return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(),"账户未激活");
        }
    }

    @GetMapping("/logout")
    public ResEntity logout(){
        SecurityUtils.getSubject().logout();
        return ResUtil.success(null,"退出成功");
    }
}
