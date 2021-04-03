package vip.huhailong.shirobyjwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import vip.huhailong.shirobyjwt.entity.UserInfo;
import vip.huhailong.shirobyjwt.entity.vo.UserInfoVO;

import java.util.List;
import java.util.Map;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/3/24.
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    IPage<UserInfoVO> getUserInfoList(Page<UserInfoVO> page,@Param("pojo") UserInfoVO pojo);
}
