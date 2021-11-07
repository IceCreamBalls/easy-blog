package com.ice.easy.blog.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AuthorizationController {


//    @GetMapping("/authorization_code")
//    public String authorization_code(String code) {
//        Map<String, String> map = new HashMap<>();
//        map.put("client_id", "bb98dbc1801f391465f6");
//        map.put("client_secret", "37cfab16987ec18fa355872c02bc660186d70566");
//        map.put("state", "cheering");
//        map.put("code", code);
//        map.put("redirect_uri", "http://localhost:8080/authorization_code");
//        Map<String,String> resp = restTemplate.postForObject("https://github.com/login/oauth/access_token", map, Map.class);
//        System.out.println(resp);
//        HttpHeaders httpheaders = new HttpHeaders();
//        httpheaders.add("Authorization", "token " + resp.get("access_token"));
//        HttpEntity<?> httpEntity = new HttpEntity<>(httpheaders);
//        ResponseEntity<Map> exchange = restTemplate.exchange("https://api.github.com/user", HttpMethod.GET, httpEntity, Map.class);
//        System.out.println("exchange.getBody() = " + exchange.getBody());
//        return "forward:/index.html";
//    }
}
