package com.ice.easy.blog.article;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ice.easy.blog.article.mapper")
public class EasyArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyArticleApplication.class, args);
    }

}
