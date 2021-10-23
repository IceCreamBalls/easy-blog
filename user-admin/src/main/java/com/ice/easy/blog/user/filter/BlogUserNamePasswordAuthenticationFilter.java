package com.ice.easy.blog.user.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ice.blog.vo.R;
import com.ice.easy.blog.user.entity.Users;
import com.ice.easy.blog.user.mapper.UsersMapper;
import com.ice.easy.blog.user.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

public class BlogUserNamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;


    public BlogUserNamePasswordAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;
    }


    /**
     * 处理登录逻辑
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            Map map = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(map.get("username"), map.get("password"))
            );
        } catch (Exception e) {
            e.printStackTrace();
            responseErrJson(response, R.error("登录失败"));
            return null;
        }

    }

    private static void responseErrJson(HttpServletResponse response, R r) {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;

        try {
            out = response.getWriter();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        JSONObject data = new JSONObject(r);
        out.write(data.toString());
        out.flush();
        out.close();
    }


    /**
     * 登录成功颁布令牌
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        try {
            SecurityContextHolder.getContext().setAuthentication(authResult);
            Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
            String name = authResult.getName();
            Object principal = authResult.getPrincipal();
            JSONObject user2Token = JSONObject.parseObject(JSON.toJSONString(principal));
            String token = JWTUtils.generateTokenExpireInMinutes(user2Token, "hgbtcb", 20);
            responseErrJson(response, R.ok(token));
//            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            responseErrJson(response, R.error("失败"));
        }
    }
}
