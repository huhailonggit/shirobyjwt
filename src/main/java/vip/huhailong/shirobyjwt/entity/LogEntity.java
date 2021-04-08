package vip.huhailong.shirobyjwt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/8.
 */
@TableName("log")
@Data
public class LogEntity implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;    //id
    private String logDescribe; //日志描述
    private Long runTime;   //执行耗时
    private String method;  //执行方法
    private String param;   //参数
    private String ipAddress;   //ip地址
    private String location;    //地址
    private String createTime;  //记录时间
    private String userId;    //操作用户
}

