package com.example.sb20231114.domain.article.article.repository;

import com.example.sb20231114.domain.article.article.entity.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@RequiredArgsConstructor
@Repository // @Service와 같은 의미
// @Component을 적어도 차이는 없다.
public class ArticleRepository {
//    ArticleArrayList를 직접 만들어서 상속받으면 가능하지만 번거러운 작업이 된다.
    private final List<Article> articles;
// 위 객체는 지금 @Bean에 등록된 객체가 없다. 그래서 자바에서 아무 객체나 넣어줬다
// 객체를 구할 때 먼저 @Component 붙은 것을 먼저 찾아본다
// 그런데 그게 없으면 다음으로  @Configuration 붙은 곳에 혹시라도 변수명이 메소드 명이랑 같고 리턴 타입이 같으면
// 그것을 실행해서 객체를 만들어서 넣어준다.
// 그래서 따로 클래스를 만들어서 상속을 하는 방법보다 이 방법을 더 많이 쓴다
// @Component를 붙이기 애매하면 @Bean 만들어 쓰면 된다.
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
