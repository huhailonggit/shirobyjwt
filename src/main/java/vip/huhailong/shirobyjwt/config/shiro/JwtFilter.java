package vip.huhailong.shirobyjwt.config.shiro;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

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

    private AntPathMatcher matcher = new AntPathMatcher();

    @SneakyThrows
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info(req.getRequestURI());
        if(matcher.match("/login",req.getRequestURI())){
            return true;
        }
        if(isLoginAttempt(request,response)){
            return executeLogin(request,response);
        }
        return false;
    }

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        return token != null;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("token");
        JWTToken jwtToken = new JWTToken(token);
        try{
            //将token传递给 shiro realm
            getSubject(request,response).login(jwtToken);
            return true;
        } catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return super.onPreHandle(request, response, mappedValue);
    }
}
