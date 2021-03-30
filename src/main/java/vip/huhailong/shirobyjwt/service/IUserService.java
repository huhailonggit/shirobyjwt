package vip.huhailong.shirobyjwt.service;

import com.baomidou.mybatisplus.extension.service.IService;
import vip.huhailong.shirobyjwt.entity.User;
import vip.huhailong.shirobyjwt.entity.vo.UserFullInfo;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/17.
 */
public interface IUserService extends IService<User> {

    User getUserByUsername(String username);

    void initUserRole(User user);
}
