package com.example.sb20231114.domain.article.article.repository;

import com.example.sb20231114.domain.article.article.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository // @Service와 같은 의미
// @Component을 적어도 차이는 없다.
public class ArticleRepository {
    private final ArrayList<Article> articles = new ArrayList<>();

    public Article save(Article article) {
        if (article.getId()==null){
            article.setId(articles.size()+1L);
        }
        articles.add(article);
        return article;
    }

    public Article findLastArticle() {
        return articles.getLast();
    }

    public List<Article> findAll() {
        return articles;
    }
}
