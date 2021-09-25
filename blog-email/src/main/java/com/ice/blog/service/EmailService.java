package com.ice.blog.service;

import org.springframework.stereotype.Service;

import java.util.Map;


public interface EmailService {

    public Map sendMessage(String to, String title, String content, Boolean setHtml);
}
