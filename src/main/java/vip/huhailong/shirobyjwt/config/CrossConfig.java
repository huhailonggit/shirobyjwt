package vip.huhailong.shirobyjwt.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Huhailong
 * @Description 跨域配置
 * @Date 2021/3/17.
 */
@Slf4j
@Configuration
public class CrossConfig implements Filter{

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain){
        log.info("coming cross filter");
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        //放行所有,类似*,这里*无效
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //允许请求方式
        response.setHeader("Access-Control-Allow-Methods", "POST,PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        //需要放行header头部字段 如需鉴权字段，自行添加，如Authorization
        response.setHeader("Access-Control-Allow-Headers", "content-type,x-requested-with,token,Authorization,authorization");
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            log.error("cross error {}:",e.getMessage());
        }

    }
}
