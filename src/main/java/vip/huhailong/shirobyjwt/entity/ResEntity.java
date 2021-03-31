package vip.huhailong.shirobyjwt.entity;

import lombok.Data;
import vip.huhailong.shirobyjwt.enums.ResEnum;

/**
 * @author Huhailong
 * @Description 响应实体
 * @Date 2021/3/17.
 */
@Data
public class ResEntity {
    private Boolean status;
    private String type;
    private Integer code;
    private Object data;
    private String message;
}
