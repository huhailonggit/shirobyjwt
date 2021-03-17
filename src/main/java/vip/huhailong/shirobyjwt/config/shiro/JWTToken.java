package vip.huhailong.shirobyjwt.config.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @program: shirobyjwt
 * @description:
 * @author: 胡海龙
 * @create: 2021-03-17 21:52:38
 **/
public class JWTToken implements AuthenticationToken {

    private String token;
    private String expireAt;

    public JWTToken(String token){
        this.token = token;
    }
    public JWTToken(String token, String expireAt){
        this.token = token;
        this.expireAt = expireAt;
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
