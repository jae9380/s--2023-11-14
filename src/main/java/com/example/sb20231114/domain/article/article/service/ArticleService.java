package com.example.sb20231114.domain.article.article.service;

import com.example.sb20231114.domain.article.article.entity.Article;
import com.example.sb20231114.domain.article.article.repository.ArticleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component // 단 한번만 생성되고, 그 이후에는 재사용되는 객체입니다. => 공융 객체
public class ArticleService {
    private final ArticleRepository articleRepository= new ArticleRepository();
    public Article write(String title, String body) {
        // service는 repository에 전달만 하고 순서는 repository가 알아서
        Article article=new Article(title,body);
        articleRepository.save(article);
        return article;
    }

    public Article findLastArticle() {
        return articleRepository.findLastArticle();
    }

    public List<Article> finAll() {
        return articleRepository.findAll();
    }
}
