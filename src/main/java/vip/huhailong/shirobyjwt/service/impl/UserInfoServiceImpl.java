package vip.huhailong.shirobyjwt.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.huhailong.shirobyjwt.entity.UserInfo;
import vip.huhailong.shirobyjwt.entity.vo.UserInfoVO;
import vip.huhailong.shirobyjwt.mapper.UserInfoMapper;
import vip.huhailong.shirobyjwt.service.IUserInfoService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/24.
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {
    @Resource
    UserInfoMapper userInfoMapper;
    @Override
    public IPage<UserInfoVO> getUserInfoList(UserInfoVO userInfoVO) {
        Page<UserInfoVO> page = new Page<>(userInfoVO.getPageNum(),userInfoVO.getPageSize());
        return userInfoMapper.getUserInfoList(page,userInfoVO);
    }
}
