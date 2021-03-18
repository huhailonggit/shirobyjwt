package vip.huhailong.shirobyjwt.config.shiro;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.service.IUserService;
import vip.huhailong.shirobyjwt.util.HttpUtils;
import vip.huhailong.shirobyjwt.util.JwtUtil;
import vip.huhailong.shirobyjwt.util.ResUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: shirobyjwt
 * @description:
 * @author: 胡海龙
 * @create: 2021-03-17 22:36:12
 **/
@Slf4j
//@Component
public class CustomRealmB extends AuthorizingRealm {
    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 必须重写，不然会报错
     *
     * @param token in coming token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 授权
     *
     * @param principalCollection token
     * @return authorization info
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("coming authorization model token -> {}", principalCollection);
        String username = JwtUtil.getUsername(principalCollection.toString());
        log.info("current token user {}", username);
        User user = userService.getUserByUsername(username);
        Set<String> set = new HashSet<>();
        user.getRoleList().forEach(role -> set.add(role.getRole()));
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(set);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //authenticationToken 来自JwtFilter 种的executeLogin
        if(authenticationToken == null){
            throw new AccountEnableException("请先登录");
        }
        String token = authenticationToken.getCredentials().toString();
        String username = JwtUtil.getUsername(token);
        if (username == null) {
            throw new AccountEnableException("token校验失败");
        }
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new AccountEnableException("用户不存在");
        }
        if (!JwtUtil.verify(token, username, user.getPassword())) {
            throw new AccountEnableException("用户名或密码错误");
        }
        if(!user.getEnable()){
            throw new AccountEnableException("账号未激活");
        }
        return new SimpleAuthenticationInfo(token, token, getName());
    }
}
