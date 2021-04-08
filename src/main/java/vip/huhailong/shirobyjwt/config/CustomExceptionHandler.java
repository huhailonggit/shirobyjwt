package vip.huhailong.shirobyjwt.config;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.enums.ResEnum;
import vip.huhailong.shirobyjwt.util.ResUtil;


/**
 * @author Huhailong
 * @Description 自定义异常处理器
 * @Date 2021/3/17.
 */
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResEntity exceptionHandler(Exception e) {
        log.error("error message:" + e.getMessage());
        e.printStackTrace();

        return ResUtil.error(ResEnum.SYSTEM_ERROR,e.getMessage());
    }
    @ExceptionHandler(UnauthenticatedException.class)
    public ResEntity exceptionHandler(UnauthenticatedException e) {
        log.error("error message:" + e.getMessage());
//        e.printStackTrace();;
        return ResUtil.error(ResEnum.UNAUTHORIZED,"请先登录");
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResEntity exceptionHandler(UnauthorizedException e) {
        log.error("error message:" + e.getMessage());
//        e.printStackTrace();
        return ResUtil.error(ResEnum.UNAUTHORIZED,"暂无权限访问");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResEntity exceptionHandler(AuthenticationException e){
        return ResUtil.error(ResEnum.UNAUTHORIZED,e.getMessage());
    }

}
