package com.ice.easy.blog.article.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ice.easy.blog.article.entity.Article;
import com.ice.easy.blog.article.mapper.ArticleMapper;
import com.ice.easy.blog.article.service.IArticleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuhao
 * @since 2021-10-23
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
