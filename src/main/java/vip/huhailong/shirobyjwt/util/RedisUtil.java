package vip.huhailong.shirobyjwt.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/31.
 */
@Component
public class RedisUtil {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    public static final long CODE_EXPIRE = 5*60*1000; //验证码有效时间为5分钟

    /**
     * 判断是否存在该key
     * @param key key
     * @return Boolean
     */
    public boolean exitsKey(String key){
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public void add(String key, String value){
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key, Duration.ofMillis(CODE_EXPIRE));
    }

    public String get(String key){
        return redisTemplate.opsForValue().get(key);
    }



}
