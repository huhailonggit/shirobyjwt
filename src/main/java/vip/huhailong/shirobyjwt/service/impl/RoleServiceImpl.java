package vip.huhailong.shirobyjwt.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import vip.huhailong.shirobyjwt.entity.Role;
import vip.huhailong.shirobyjwt.mapper.RoleMapper;
import vip.huhailong.shirobyjwt.service.IRoleService;

/**
 * @author Huhailong
 * @Description
 * @Date 2021/4/2.
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
}
