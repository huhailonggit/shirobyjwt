package vip.huhailong.shirobyjwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import vip.huhailong.shirobyjwt.entity.Role;
import vip.huhailong.shirobyjwt.entity.User;

import java.util.List;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
public interface UserMapper extends BaseMapper<User> {

    List<Role> getRoleByUserId(@Param("id") String id);

    User getUserByUsername(@Param("username") String username);
}
