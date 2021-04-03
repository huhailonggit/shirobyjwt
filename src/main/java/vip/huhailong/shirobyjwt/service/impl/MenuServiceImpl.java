package vip.huhailong.shirobyjwt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.huhailong.shirobyjwt.entity.BaseEntity;
import vip.huhailong.shirobyjwt.entity.Menu;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.mapper.MenuMapper;
import vip.huhailong.shirobyjwt.service.IMenuService;
import vip.huhailong.shirobyjwt.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: shirobyjwt
 * @description: 菜单接口
 * @author: 胡海龙
 * @create: 2021-04-03 10:22:07
 **/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Resource
    MenuMapper menuMapper;
    @Autowired
    IUserService userService;
    @Override
    public IPage<Menu> getMenuList(BaseEntity entity) {
        Page<Menu> page = new Page<>();
        if(entity.hasPage()){
            page.setCurrent(entity.getPageNum());
            page.setSize(entity.getPageSize());
        }
        return menuMapper.selectPage(page, new QueryWrapper<Menu>().like("menu_name", entity.getLikeName()));
    }

    @Override
    public List<Menu> getMenuByUser(String username) {
        User user = userService.getUserByUsername(username);
        return menuMapper.getMenuByUser(user.getId());
    }
}
