package vip.huhailong.shirobyjwt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/2.
 */
@Data
public class BaseEntity implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private String likeName;

    public boolean hasPage(){
        return this.pageNum != null && this.pageSize != null;
    }
}
