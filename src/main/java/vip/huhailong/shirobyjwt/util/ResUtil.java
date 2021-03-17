package vip.huhailong.shirobyjwt.util;

import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.enums.ResEnum;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
public class ResUtil {

    public static ResEntity success(Object o, String message){
        ResEntity resEntity = new ResEntity();
        resEntity.setStatus(true);
        resEntity.setCode(ResEnum.REQUEST_SUCCESS.getCode());
        resEntity.setMessage(message);
        resEntity.setData(o);
        return resEntity;
    }

    public static ResEntity error(Integer code, String message){
        ResEntity resEntity = new ResEntity();
        resEntity.setStatus(false);
        resEntity.setMessage(message);
        resEntity.setCode(code);
        return resEntity;
    }


}
