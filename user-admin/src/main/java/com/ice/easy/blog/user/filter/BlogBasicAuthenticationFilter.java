package com.ice.easy.blog.user.filter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ice.blog.vo.R;
import com.ice.easy.blog.user.utils.JWTUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BlogBasicAuthenticationFilter extends BasicAuthenticationFilter {

    public BlogBasicAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    public BlogBasicAuthenticationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("token");
        if(token == null){
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            R error = R.error(403, "请登录!");
            PrintWriter out = response.getWriter();
            out.write(new ObjectMapper().writeValueAsString(error));
            out.flush();
            out.close();
            return;
        }

        try {
            UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) throws  Exception {
        String token = request.getHeader("token");
        if(token != null){
            JSONObject userInfo = JWTUtils.getInfoFromToken(token, "hgbtcb");
            String username = userInfo.getString("username");
            List<GrantedAuthority> noAuthorities = AuthorityUtils.NO_AUTHORITIES;
            return new  UsernamePasswordAuthenticationToken(username, null, noAuthorities );
        }


        return null;
    }
}
