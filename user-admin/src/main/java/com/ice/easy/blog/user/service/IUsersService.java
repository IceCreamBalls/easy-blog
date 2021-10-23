package com.ice.easy.blog.user.service;

import com.ice.blog.vo.R;
import com.ice.easy.blog.user.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.catalina.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuhao
 * @since 2021-09-20
 */
public interface IUsersService extends IService<Users> {

    /**
     * 注册用户
     * @param user
     * @return
     */
    public R  signin(Users user);

}
