package vip.huhailong.shirobyjwt.enums;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * @author Huhailong
 * @Description 响应枚举
 * @Date 2021/3/17.
 */
public enum ResEnum {
    REQUEST_SUCCESS(200),
    NOT_FOUND(404),
    SYSTEM_ERROR(500),
    UNAUTHORIZED(403),
    ;

    public Integer code;

    ResEnum(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
