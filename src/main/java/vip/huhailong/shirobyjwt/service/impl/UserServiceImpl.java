package vip.huhailong.shirobyjwt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.mapper.UserMapper;
import vip.huhailong.shirobyjwt.service.IUserService;

import javax.annotation.Resource;

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
}
