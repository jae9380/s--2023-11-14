package com.example.sb20231114.domain.article.article.service;

import com.example.sb20231114.domain.article.article.entity.Article;
import com.example.sb20231114.domain.article.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // @Service는 Service Component라는 의미다. 가독성을 좀 더 좋게하기 위해 이름을 변경
// @Service <-> @Component 둘은 별 차이가 없다.
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
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
