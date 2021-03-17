package vip.huhailong.shirobyjwt.config;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
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
        e.printStackTrace();
        return ResUtil.error(ResEnum.SYSTEM_ERROR.getCode(),e.getMessage());
    }
}
