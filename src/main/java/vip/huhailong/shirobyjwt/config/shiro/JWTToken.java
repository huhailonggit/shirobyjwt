package vip.huhailong.shirobyjwt.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @program: shirobyjwt
 * @author: 胡海龙
 * @create: 2021-03-17 21:52:38
 **/

public class JWTToken implements AuthenticationToken{

    private String token;   //密匙

    public JWTToken(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
