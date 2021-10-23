package com.ice.easy.blog.user.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ice.easy.blog.user.entity.Users;
import com.ice.easy.blog.user.mapper.UsersMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class BlogUserDetailService implements UserDetailsService {
    @Resource
    UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("name",username);

        Users users = usersMapper.selectOne(wrapper);

        if(users == null){
            return null;
        }

        List<GrantedAuthority> noAuthorities = AuthorityUtils.NO_AUTHORITIES;

        return new User(username, users.getPassword(), noAuthorities);
    }
}
