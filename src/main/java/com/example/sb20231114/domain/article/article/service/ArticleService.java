package com.example.sb20231114.domain.article.article.service;

import com.example.sb20231114.domain.article.article.entity.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleService {
    private final ArrayList<Article> articles = new ArrayList<>();

    public Article write(String title, String body) {
        Article article=new Article(articles.size()+1,title,body);
        articles.add(article);
        return article;
    }

    public Article findLastArticle() {
        return articles.get(articles.size()-1);
    }

    public List<Article> finAll() {
        return articles;
    }
}
