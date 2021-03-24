package vip.huhailong.shirobyjwt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.huhailong.shirobyjwt.entity.UserInfo;
import vip.huhailong.shirobyjwt.mapper.UserInfoMapper;
import vip.huhailong.shirobyjwt.service.IUserInfoService;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/24.
 */
@Service
public class UserInfoImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
}
