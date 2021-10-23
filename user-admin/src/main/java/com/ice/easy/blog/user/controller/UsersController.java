package com.ice.easy.blog.user.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ice.blog.vo.R;
import com.ice.easy.blog.user.entity.Users;
import com.ice.easy.blog.user.mapper.UsersMapper;
import com.ice.easy.blog.user.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户前端控制器
 * </p>
 *
 * @author liuhao
 * @since 2021-09-20
 */
@RestController
@CrossOrigin
public class UsersController {
    @Autowired
    IUsersService iUsersService;
    @Resource
    private UsersMapper usersMapper;

    @PostMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_VALUE)
    public R signIn(@RequestBody Users users) {
        return iUsersService.signin(users);
    }


    @PostMapping(value = "/success", produces = MediaType.APPLICATION_JSON_VALUE)
    public void login(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        System.out.println(name);
    }

    @GetMapping("/userInfo/{id}")
    public R userinfo(@PathVariable Integer id){
        Users users = usersMapper.selectById(id);
        if(users != null){
            users.setPassword(null);
            try {
                return R.ok(JSONObject.parseObject(JSON.toJSONString(users)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return R.ok();
    }

    @GetMapping("/userInfo")
    public R userinfo(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        Users users = usersMapper.selectOne(wrapper);
        if(users != null){
            users.setPassword(null);
            return R.ok(JSONObject.parseObject(JSON.toJSONString(users)));
        }
        return R.ok();
    }

}
