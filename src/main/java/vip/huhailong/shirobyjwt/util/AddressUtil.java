package vip.huhailong.shirobyjwt.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 *	根据IP地址获取详细的地域信息
 *	百度API : https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?resource_id=6006&query={ip}<br>
 */
@Component
public class AddressUtil {

    @Autowired
    private RestTemplate restTemplate;
    //	淘宝API
    private static final String API_URL = "https://sp0.baidu.com/8aQDcjqpAAV3otqbppnN2DJv/api.php?resource_id=6006&query=";

    @SuppressWarnings("unchecked")
    public String getLocation(String ip){
        String url = API_URL+ip;
        String forEntity = restTemplate.getForEntity(URI.create(url), String.class).getBody();
        JSONObject jsonObject = JSON.parseObject(forEntity);
        List<Map<String,Object>> data = (List<Map<String, Object>>) JSON.parse(jsonObject.getString("data"));
        if(data != null && data.size() > 0){
            return data.get(0).get("location").toString();
        }else{
            return "本地局域网";
        }
    }

}
