package vip.huhailong.shirobyjwt.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/2.
 */
@Data
public class UserRoleVO {
    private String userId;
    private List<String> roleIds;
}
