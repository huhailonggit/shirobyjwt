package vip.huhailong.shirobyjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.service.IUserService;
import vip.huhailong.shirobyjwt.util.HttpUtils;
import vip.huhailong.shirobyjwt.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/23.
 */
@RestController
@RequestMapping("/page")
public class PageController {
    @Autowired
    IUserService userService;
    @Value("${server-mail.url}")
    private String pageUrl;
    @GetMapping("/enableUser")
    public void enableUser(String token, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = JwtUtil.getUsername(token);
        if(username==null){
            HttpUtils.responseContent("token非法，请重新登录获取激活链接",request,response);
        }
        User user = userService.getUserByUsername(username);
        String pwd = user.getPassword();
        boolean verify = JwtUtil.verify(token, username, pwd);
        if(!verify){
            HttpUtils.responseContent("token非法，请重新登录获取激活链接",request,response);
        }
        user.setEnable(true);
        userService.updateById(user);
        response.sendRedirect(pageUrl);
    }
}
