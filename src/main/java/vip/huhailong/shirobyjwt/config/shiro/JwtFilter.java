package vip.huhailong.shirobyjwt.config.shiro;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpHeaders;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.enums.ResEnum;
import vip.huhailong.shirobyjwt.util.HttpUtils;
import vip.huhailong.shirobyjwt.util.ResUtil;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

    /**
     * 判断用户是否想要登录
     * 检测header种是否包含Authorization字段
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(HttpHeaders.AUTHORIZATION);
        return authorization != null;
    }

    /**
     * 执行登录
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader(HttpHeaders.AUTHORIZATION);
        JWTToken token = new JWTToken(authorization);
        getSubject(request, response).login(token);
        return true;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        log.info("是否拦截"+isLoginAttempt(request,response));
        if (isLoginAttempt(request, response)) {
            try {
                executeLogin(request, response);
            } catch (Exception e) {
                ResEntity error = ResUtil.error(ResEnum.UNAUTHORIZED, e.getMessage());
                HttpUtils.responseContent(JSONObject.toJSONString(error),request,response);
            }
        }
        return true;
    }

}
