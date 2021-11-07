package com.ice.easy.blog.article.controller;


import com.ice.blog.vo.R;
import com.ice.easy.blog.article.entity.Article;
import com.ice.easy.blog.article.mapper.ArticleMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuhao
 * @since 2021-10-23
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    ArticleMapper articleMapper;


    @PostMapping(path = "/insert")
    public R insertArticle(@RequestBody Article article){
        int i = articleMapper.insert(article);
        return i > 0 ? R.ok("新增成功") : R.error("新增失败");
    }
}
