package com.ice.blog.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.ice.blog.entity.EmailFrom;
import com.ice.blog.service.EmailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


@Service
public class EmailServiceImpl implements EmailService {
    @Resource
    private EmailFrom emailFrom;

    @Override
    public Map sendMessage(String to, String title, String content, Boolean setHtml) {

        MailAccount account = new MailAccount();
        account.setHost(emailFrom.getHost());
        account.setPort(emailFrom.getPort());
        account.setFrom(emailFrom.getFrom());
        account.setUser(emailFrom.getUser());
        account.setPass(emailFrom.getPass());
        System.out.println(emailFrom.getUser());
//        System.out.println(host);
        MailUtil.send(account, CollUtil.newArrayList(to), title, content, setHtml);

        return null;
    }
}
