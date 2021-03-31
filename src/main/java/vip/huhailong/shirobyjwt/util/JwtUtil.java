package vip.huhailong.shirobyjwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/16.
 */
@Slf4j
public class JwtUtil {

    public static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;  //设置过期时间为1天
    public static final long CODE_EXPIRE_TIME = 5*60*1000;  //验证码，有效期五分钟

    /**
     * 校验token
     * @param token 携带token
     * @param username 用户名
     * @param secret 盐
     * @return 返回校验结果
     */
    public static boolean verify(String token, String username, String secret){
        try{
            //根据密码生成校验器
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username",username).build();
            //校验token
            DecodedJWT jwt = verifier.verify(token);
            log.info(jwt+":-token is verify");
            return true;
        } catch (Exception e){
            log.info("This token is invalid {}",e.getMessage());
            return false;
        }
    }

    /**
     * 获取token中的i西南西，无需secret
     * @param token 携带token
     * @return 返回用户名
     */
    public static String getUsername(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        }catch (Exception e){
            log.error("error:{}"+e.getMessage());
            return null;
        }
    }

    /**
     * 生成token
     * @param username 用户名
     * @param secret 盐
     * @return 返回生成的token
     */
    public static String sign(String username, String secret){
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        //添加username信息
        return JWT.create().withClaim("username",username).withExpiresAt(date).sign(algorithm);
    }

    public static String signCode(String mail, String code){
        Date date = new Date(System.currentTimeMillis()+CODE_EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(code);
        //添加username信息
        return JWT.create().withClaim("username",mail).withExpiresAt(date).sign(algorithm);
    }


}
