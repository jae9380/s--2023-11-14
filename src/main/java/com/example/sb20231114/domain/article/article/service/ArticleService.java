package com.example.sb20231114.domain.article.article.service;

import com.example.sb20231114.domain.article.article.entity.Article;
import com.example.sb20231114.domain.article.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // @Service는 Service Component라는 의미다. 가독성을 좀 더 좋게하기 위해 이름을 변경
// @Service <-> @Component 둘은 별 차이가 없다.
public class ArticleService {
    private final ArticleRepository articleRepository;
    // 세터 주입은 객체를 만들 때 null이 들어가지만
    // 생성자 주입은 만들자 마자 값을 넣어주기 때문에 final 가능
    @Autowired// 생성자 주입
    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository= articleRepository;
    }
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
