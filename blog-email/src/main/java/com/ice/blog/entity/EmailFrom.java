package com.ice.blog.entity;

import cn.hutool.extra.mail.MailAccount;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "email")
public class EmailFrom {
    private  String host;
    private  Integer port;
    private  String from;
    private  String user;
    private  String pass;
}
