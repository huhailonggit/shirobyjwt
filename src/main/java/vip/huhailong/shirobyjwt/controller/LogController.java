package vip.huhailong.shirobyjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.huhailong.shirobyjwt.entity.BaseEntity;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.service.ILogService;
import vip.huhailong.shirobyjwt.util.ResUtil;

import java.util.List;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/8.
 */
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    ILogService logService;

    @GetMapping("/list")
    public ResEntity list(BaseEntity entity){
        return ResUtil.success(logService.list(entity),"查询成功");
    }

    @PostMapping("del")
    public ResEntity del(@RequestBody List<String> ids){
        logService.removeByIds(ids);
        return ResUtil.success(null,"删除成功");
    }
}
