package vip.huhailong.shirobyjwt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.huhailong.shirobyjwt.entity.Role;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.entity.vo.UserFullInfo;
import vip.huhailong.shirobyjwt.entity.vo.UserInfoVO;

import java.util.List;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
public interface IUserService extends IService<User> {

    User getUserByUsername(String username);

    void initUserRole(User user);

    List<Role> getRoleListByUserId(String userId);

    int addRole(String userId, String roleId);

    int delRole(String userId, List<String> roleIds);

}
