package vip.huhailong.shirobyjwt.config.shiro;

import org.apache.shiro.authc.AccountException;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
public class AccountEnableException extends AccountException {

    public AccountEnableException(String message){
        super(message);
    }
}
