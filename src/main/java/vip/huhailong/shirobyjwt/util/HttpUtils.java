package vip.huhailong.shirobyjwt.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class HttpUtils {

    public static void responseContent(String jsonString, ServletRequest httpRequest, ServletResponse httpResponse){
        HttpServletRequest request = (HttpServletRequest)httpRequest;
        HttpServletResponse response = (HttpServletResponse)httpResponse;
        //设置response的相关属性，为跨域做准备
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //允许请求方式
        response.setHeader("Access-Control-Allow-Methods", "POST,PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        //需要放行header头部字段 如需鉴权字段，自行添加，如Authorization
        response.setHeader("Access-Control-Allow-Headers", "content-type,x-requested-with,token,Authorization,authorization");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");


        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println(jsonString);
        } catch (IOException e) {
            log.info("出现异常"+e.getMessage());
            e.printStackTrace();
        }finally {
            assert out != null;
            out.flush();
            out.close();
        }

    }
}
