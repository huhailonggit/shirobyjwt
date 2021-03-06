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

    int initUserRole(@Param("userId")String userId);

    int initUserInfo(@Param("userId") String userId);

    int addRole(@Param("userId")String userId, @Param("roleId") String roleId);

    int delRole(@Param("userId")String userId, @Param("list") List<String> list);
}
