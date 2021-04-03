package vip.huhailong.shirobyjwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import vip.huhailong.shirobyjwt.entity.Menu;

import java.util.List;

/**
 * @program: shirobyjwt
 * @description:
 * @author: 胡海龙
 * @create: 2021-04-03 10:21:08
 **/
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenuByUser(@Param("userId") String userId);
}
