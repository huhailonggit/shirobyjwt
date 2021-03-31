package vip.huhailong.shirobyjwt.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @program: emap
 * @description: 生成UUID工具
 * @author: huhailong
 * @create: 2020-05-18 10:59
 **/
@Component
public class MakeUUID {
    /**
     * 获取UUID
     * @param length 获取的长度
     * @param replace 是否显示UUID终的横线
     * @return return UUID
     */
    public static String getUUID(Boolean replace, Integer length){
        if(replace){
            return UUID.randomUUID().toString().substring(0,length);
        }else{
            return UUID.randomUUID().toString().replace("-","").substring(0,length);
        }
    }

    public static String getUUID(Boolean replace){
        if(replace){
            return UUID.randomUUID().toString();
        }else{
            return UUID.randomUUID().toString().replace("-","");
        }
    }
}
