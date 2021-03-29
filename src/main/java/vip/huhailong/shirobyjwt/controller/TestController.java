package vip.huhailong.shirobyjwt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.huhailong.shirobyjwt.util.HttpUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/25.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/httpResTest")
    public void httpResTest(HttpServletRequest request, HttpServletResponse response){
        Map<String,String> map = new HashMap<>();
        map.put("name","huhailong");
        map.put("status","success");
        map.put("site","https://www.huhailong.vip");
        HttpUtils.responseContent(JSON.toJSONString(map),request, response);
    }
}
