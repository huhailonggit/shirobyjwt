package vip.huhailong.shirobyjwt.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vip.huhailong.shirobyjwt.entity.BaseEntity;
import vip.huhailong.shirobyjwt.entity.Menu;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.entity.vo.MenuRoleVO;
import vip.huhailong.shirobyjwt.service.IMenuService;
import vip.huhailong.shirobyjwt.util.JwtUtil;
import vip.huhailong.shirobyjwt.util.ResUtil;

import java.util.List;

/**
 * @program: shirobyjwt
 * @description:
 * @author: 胡海龙
 * @create: 2021-04-03 10:23:14
 **/
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    IMenuService menuService;

    @GetMapping("/list")
    public ResEntity list(BaseEntity entity){
        return ResUtil.success(menuService.getMenuList(entity),"查询成功");
    }

    @GetMapping("/getMenuByUser")
    public ResEntity getMenuByUser(){
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        String username = JwtUtil.getUsername(token);
        return ResUtil.success(menuService.getMenuByUser(username),"查询成功");
    }

    @PostMapping("/updateMenu")
    @RequiresRoles("admin")
    public ResEntity updateMenu(@RequestBody List<Menu> list){
        menuService.updateBatchById(list);
        return ResUtil.success(null,"修改成功");
    }

    @PostMapping("/addMenu")
    @RequiresRoles("admin")
    public ResEntity addMenu(@RequestBody Menu menu){
        menuService.addMenu(menu);
        return ResUtil.success(null,"添加成功");
    }

    @GetMapping("/getAllList")
    public ResEntity getAllList(){
        return ResUtil.success(menuService.list(new QueryWrapper<Menu>().orderByDesc("menu_order")),"获取成功");
    }

    @PostMapping("/bindRole")
    @RequiresRoles("admin")
    public ResEntity bindRole(@RequestBody MenuRoleVO vo){
        menuService.bindRole(vo);
        return ResUtil.success(null,"绑定成功");
    }

    @GetMapping("/currentRole")
    public ResEntity currentRole(String menuId){
        return ResUtil.success(menuService.currentRole(menuId),"查询成功");
    }

    @PostMapping("delete")
    @RequiresRoles("admin")
    public ResEntity delete(@RequestBody List<String> ids){
        menuService.deleteMenu(ids);
        return ResUtil.success(null,"删除成功");
    }
}
