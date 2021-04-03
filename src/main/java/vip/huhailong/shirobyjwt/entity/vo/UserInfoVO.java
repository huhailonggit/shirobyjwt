package vip.huhailong.shirobyjwt.entity.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vip.huhailong.shirobyjwt.entity.BaseEntity;

import java.io.Serializable;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/2.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoVO extends BaseEntity implements Serializable {
    private String userId;
    private String username;
    private Boolean locked;
    private Boolean enable;
    private String enableMail;
    private String avatar;
    private String nickName;
    private String gender;
    private String job;
    private String phone;
    private String birthday;
}
