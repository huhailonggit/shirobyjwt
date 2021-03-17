package vip.huhailong.shirobyjwt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@TableName("role")
@Data
public class Role {
    private String id;
    private String role;
    private String roleName;
}
