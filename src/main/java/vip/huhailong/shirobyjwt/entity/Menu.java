package vip.huhailong.shirobyjwt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: shirobyjwt
 * @description: 菜单
 * @author: 胡海龙
 * @create: 2021-04-03 10:18:32
 **/
@Data
@TableName("menu")
public class Menu implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String menuName;
    private String menuIcon;
    private String router;
    private String click;
    private String parent;
    private Integer menuOrder;
}
