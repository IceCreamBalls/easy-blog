package com.ice.easy.blog.user.controller;


import com.ice.easy.blog.user.entity.Users;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuhao
 * @since 2021-09-20
 */
@RestController
@RequestMapping("/user/users")
@CrossOrigin
public class UsersController {

    @PostMapping(value = "/signin", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> signIn(@RequestBody Users users){

        return new HashMap<String, String>(){{
            put("status", "2000");
            put("msg","OK");
        }};
    }



}
