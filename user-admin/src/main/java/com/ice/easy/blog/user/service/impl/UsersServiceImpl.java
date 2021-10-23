package com.ice.easy.blog.user.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ice.blog.vo.R;
import com.ice.easy.blog.user.entity.Users;
import com.ice.easy.blog.user.mapper.UsersMapper;
import com.ice.easy.blog.user.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

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

    @Autowired
    UsersMapper usersMapper;


    @Override
    public R signin(Users user) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("phone", user.getPhone()).or().eq("email", user.getEmail());
        Users userExit = usersMapper.selectOne(wrapper);
        String dateTime = DateUtil.formatDateTime(new Date());
        user.setCreateAt(dateTime);
        user.setUpdateAt(dateTime);
        if(userExit != null){
            if(userExit.getEmail().equals(user.getEmail())){
                return R.error("邮箱已被注册，请更换邮箱");
            }else if(userExit.getPhone().equals(user.getPhone())){
                return R.error("手机号已被注册，请更换手机号");
            }
            return R.error("网络异常，请稍后重试");
        }else{
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
            String encode = encoder.encode(user.getPassword());
            user.setPassword(encode);
            int isOk = usersMapper.insert(user);
            if(isOk > 0){
                //todo 前往邮箱激活账号
                return R.ok("新增用户成功，请前往邮箱激活账号");
            }
            return R.error("网络异常，请稍后重试");
        }
    }
}
