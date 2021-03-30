package vip.huhailong.shirobyjwt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/24.
 */
@TableName("user_info")
@Data
public class UserInfo {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String nickName;
    private String gender;  //m(男) w(女)
    private String phone;
    private String job;
    private String birthday;
    private String userId;
    private String avatar;
}
