package vip.huhailong.shirobyjwt.config;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vip.huhailong.shirobyjwt.config.shiro.AccountEnableException;
import vip.huhailong.shirobyjwt.config.shiro.ExpireException;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.enums.ResEnum;
import vip.huhailong.shirobyjwt.util.ResUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Huhailong
 * @Description 自定义异常处理器
 * @Date 2021/3/17.
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResEntity exceptionHandler(Exception e) {
        log.error("error message:" + e.getMessage());
        log.error(e.getMessage());
        return ResUtil.error(ResEnum.SYSTEM_ERROR.getCode(),e.getMessage());
    }
    @ExceptionHandler
    public ResEntity exceptionHandler(UnauthenticatedException e) {
        log.error("error message:" + e.getMessage());
        log.error(e.getMessage());
        return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(),"请先登录");
    }

    @ExceptionHandler
    public ResEntity exceptionHandler(UnauthorizedException e) {
        log.error("error message:" + e.getMessage());
        log.error(e.getMessage());
        return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(),"暂无权限访问");
    }

    @ExceptionHandler(AccountEnableException.class)
    public ResEntity exceptionHandler(AccountEnableException e){
        return ResUtil.error(ResEnum.UNAUTHORIZED.getCode(),"用户未激活");
    }

}
