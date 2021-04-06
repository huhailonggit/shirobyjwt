package vip.huhailong.shirobyjwt.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/6.
 */
@Data
public class MenuRoleVO {
    private String menuId;
    private List<String> roleIds;
}
