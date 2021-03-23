package vip.huhailong.shirobyjwt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Huhailong
 * @Description 用户表
 * @Date 2021/3/17.
 */
@Data
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;              //用户ID
    private String username;        //用户名
    private String password;        //用户密码
    private String enableMail;      //激活邮箱
    private Boolean enable;         //是否激活
    private Boolean locked;         //是否锁定
    private Boolean expire;         //是否过期
    private String createTime;
    @TableField(exist = false)
    private List<Role> roleList;    //角色列表
}
