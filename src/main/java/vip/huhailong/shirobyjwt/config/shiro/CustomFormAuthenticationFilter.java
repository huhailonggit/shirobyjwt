package vip.huhailong.shirobyjwt.config.shiro;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 判断当前subject是否通过了验证，如果是option请求没有通过则放行
     * @param request subject request
     * @param response subject response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        boolean allowed = super.isAccessAllowed(request, response, mappedValue);
        if(!allowed){
            HttpServletRequest req = (HttpServletRequest) request;
            if(RequestMethod.OPTIONS.name().equalsIgnoreCase(req.getMethod())) return true; //如果是OPTIONS请求则不拦截
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }

    /**
     * 处理由isAccessAllowed方法拒绝的请求
     * @param request the incoming request
     * @param response the outgoing response
     * @return true: 继续处理请求
     * @throws Exception 处理出错时的异常
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if(isLoginRequest(request,response)){
            if(isLoginSubmission(request,response)){
                return executeLogin(request,response);
            }else{
                return true;
            }
        }else{
            ResEntity error = ResUtil.error(ResEnum.UNAUTHORIZED, "未登录-请重新登录");
            HttpUtils.responseContent(JSONObject.toJSONString(error),request,response);
            return false;
        }
    }
}
