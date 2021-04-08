package vip.huhailong.shirobyjwt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.huhailong.shirobyjwt.entity.BaseEntity;
import vip.huhailong.shirobyjwt.entity.LogEntity;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/8.
 */
public interface ILogService extends IService<LogEntity> {
    IPage<LogEntity> list(BaseEntity entity);
}
