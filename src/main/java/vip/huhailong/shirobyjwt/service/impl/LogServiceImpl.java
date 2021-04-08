package vip.huhailong.shirobyjwt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.huhailong.shirobyjwt.entity.BaseEntity;
import vip.huhailong.shirobyjwt.entity.LogEntity;
import vip.huhailong.shirobyjwt.mapper.LogMapper;
import vip.huhailong.shirobyjwt.service.ILogService;

import javax.annotation.Resource;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/8.
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, LogEntity> implements ILogService {
    @Resource
    LogMapper logMapper;

    @Override
    public IPage<LogEntity> list(BaseEntity entity) {
        Page<LogEntity> page = new Page<>();
        if(entity.hasPage()){
            page.setCurrent(entity.getPageNum());
            page.setSize(entity.getPageSize());
        }
        QueryWrapper<LogEntity> wrapper = new QueryWrapper<>();
        if(entity.getLikeName()!=null&&!entity.getLikeName().isEmpty()){
            wrapper.like("log_describe",entity.getLikeName());
        }
        return logMapper.selectPage(page,wrapper.orderByDesc("create_time"));
    }
}
