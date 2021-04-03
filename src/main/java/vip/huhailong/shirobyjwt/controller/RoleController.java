package vip.huhailong.shirobyjwt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.entity.Role;
import vip.huhailong.shirobyjwt.service.IRoleService;
import vip.huhailong.shirobyjwt.util.ResUtil;

import java.util.List;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/2.
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    IRoleService roleService;

    @GetMapping("/getRoleList")
    public ResEntity getRoleList(){
        List<Role> roleList = roleService.list();
        return ResUtil.success(roleList,"查询成功");
    }

    @PostMapping("/addRole")
    public ResEntity addRole(@RequestBody Role role){
        roleService.save(role);
        return ResUtil.success(null,"添加成功");
    }

    @PostMapping("/deleteRole")
    public ResEntity deleteRole(@RequestBody List<String> ids){
        roleService.removeByIds(ids);
        return ResUtil.success(null,"删除成功");
    }

    @PostMapping("/updateRole")
    public ResEntity updateRole(@RequestBody Role role){
        roleService.updateById(role);
        return ResUtil.success(null,"更新成功");
    }
}
