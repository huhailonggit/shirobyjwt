package vip.huhailong.shirobyjwt.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.huhailong.shirobyjwt.entity.BaseEntity;
import vip.huhailong.shirobyjwt.entity.Menu;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.service.IMenuService;
import vip.huhailong.shirobyjwt.util.JwtUtil;
import vip.huhailong.shirobyjwt.util.ResUtil;

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
}
