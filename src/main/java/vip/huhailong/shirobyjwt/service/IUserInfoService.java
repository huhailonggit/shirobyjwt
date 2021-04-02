package vip.huhailong.shirobyjwt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import vip.huhailong.shirobyjwt.entity.UserInfo;
import vip.huhailong.shirobyjwt.entity.vo.UserInfoVO;

import java.util.List;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/24.
 */
public interface IUserInfoService extends IService<UserInfo> {
    IPage<UserInfoVO> getUserInfoList(UserInfoVO userInfoVO);
}
