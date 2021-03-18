package vip.huhailong.shirobyjwt.config.shiro;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
public class AccountEnableException extends AuthenticationException {

    public AccountEnableException(String message){
        super(message);
    }
}
