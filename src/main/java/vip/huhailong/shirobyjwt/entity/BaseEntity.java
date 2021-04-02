package vip.huhailong.shirobyjwt.entity;

import lombok.Data;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/2.
 */
@Data
public class BaseEntity {
    private Integer pageNum;
    private Integer pageSize;

    public boolean hasPage(){
        return this.pageNum != null && this.pageSize != null;
    }
}
