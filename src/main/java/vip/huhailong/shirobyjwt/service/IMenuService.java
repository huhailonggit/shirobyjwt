package vip.huhailong.shirobyjwt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.huhailong.shirobyjwt.entity.BaseEntity;
import vip.huhailong.shirobyjwt.entity.Menu;

import java.util.List;

/**
 * @program: shirobyjwt
 * @description:
 * @author: 胡海龙
 * @create: 2021-04-03 10:21:40
 **/
public interface IMenuService extends IService<Menu> {

    IPage<Menu> getMenuList(BaseEntity entity);

    List<Menu> getMenuByUser(String username);
}
