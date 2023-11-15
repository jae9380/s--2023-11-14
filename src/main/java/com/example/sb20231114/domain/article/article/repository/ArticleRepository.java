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
// @Bean을 2개를 만들었다.
// 기존의 @Bean을 이름을 바꾸었다.
// 그러면 기존에는 LinkedList를 사용했지만, 이번에는 ArrayList를 사용한다.
//
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
