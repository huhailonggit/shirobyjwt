package vip.huhailong.shirobyjwt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.huhailong.shirobyjwt.entity.Role;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.entity.vo.UserFullInfo;
import vip.huhailong.shirobyjwt.entity.vo.UserInfoVO;
import vip.huhailong.shirobyjwt.mapper.UserMapper;
import vip.huhailong.shirobyjwt.service.IUserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public void initUserRole(User user) {
        userMapper.initUserRole(user.getId());
        userMapper.initUserInfo(user.getId());
    }

    @Override
    public List<Role> getRoleListByUserId(String userId) {
        return userMapper.getRoleByUserId(userId);
    }

    @Override
    public int addRole(String userId, String roleId) {
        return userMapper.addRole(userId,roleId);
    }

    @Override
    public int delRole(String userId, List<String> roleIds) {
        return userMapper.delRole(userId,roleIds);
    }
}
