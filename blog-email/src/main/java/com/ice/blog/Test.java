package com.ice.blog;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;

public class Test {
    public static void main(String[] args) {
        MailAccount account = new MailAccount();
        account.setHost("smtp.163.com");
//        account.setPort(25);
        account.setAuth(true);
        account.setFrom("cyhd_200024@163.com");
        account.setUser("cyhd_200024@163.com");
        account.setPass("DBESGYPCCJICOABG");

        MailUtil.send(account, CollUtil.newArrayList("icecheering@163.com"), "测试", "邮件来自Hutool测试", false);
    }
}
