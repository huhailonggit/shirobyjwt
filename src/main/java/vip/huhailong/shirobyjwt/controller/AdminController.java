package vip.huhailong.shirobyjwt.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.huhailong.shirobyjwt.entity.ResEntity;
import vip.huhailong.shirobyjwt.util.ResUtil;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/18.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/test")
    @RequiresRoles("admin")
    public String test(){
        return "request admin api successful!";
    }

    @GetMapping("/getUserInfoList")
    public ResEntity getUserInfoList(){
        return ResUtil.success(null,"查询成功");
    }
}
