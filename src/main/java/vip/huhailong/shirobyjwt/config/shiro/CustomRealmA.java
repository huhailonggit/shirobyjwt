package vip.huhailong.shirobyjwt.config.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.service.IUserService;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@Component
public class CustomRealmA extends AuthorizingRealm {
    @Autowired
    IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = SecurityUtils.getSubject().getPrincipal().toString(); //获取用户名
        User user = userService.getUserByUsername(username);
        Set<String> roleSet = new HashSet<>();
        //获取该用户的权限
        if(user.getRoleList() != null ){
            user.getRoleList().forEach(role -> roleSet.add(role.getRole()));
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  //将角色信息添加到授权信息中
        authorizationInfo.addRoles(roleSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        User user = userService.getUserByUsername(username);
        if(user == null){
            throw new UnknownAccountException("该用户不存在");
        }
        if(!user.getEnable()){
            throw new AccountEnableException("账户未激活");
        }
        if(user.getLocked()){
            throw new LockedAccountException("账户被锁定，暂时无法登录");
        }
        if(user.getExpire()){
            throw new ExpireException("用户已过期，无法登录");
        }
        return new SimpleAuthenticationInfo(username, user.getPassword(), ByteSource.Util.bytes(username),getName());
    }
}
