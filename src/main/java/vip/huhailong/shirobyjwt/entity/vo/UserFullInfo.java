package vip.huhailong.shirobyjwt.entity.vo;

import lombok.Data;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.entity.UserInfo;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/30.
 */
@Data
public class UserFullInfo {
    private User user;
    private UserInfo userInfo;
}
