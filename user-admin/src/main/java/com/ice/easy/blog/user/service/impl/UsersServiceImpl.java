package com.ice.easy.blog.user.service.impl;

import com.ice.easy.blog.user.entity.Users;
import com.ice.easy.blog.user.mapper.UsersMapper;
import com.ice.easy.blog.user.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuhao
 * @since 2021-09-20
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
