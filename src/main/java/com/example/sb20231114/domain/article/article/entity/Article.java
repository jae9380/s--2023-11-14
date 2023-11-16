package com.example.sb20231114.domain.article.article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Article {
    private Long id;
    private String title, body;
    // @AllArgsConstructor덕분에 3개에 대한 생성자는 있는데, id를 제외한 나머지에 대한 생성자는 없다.
    // 그래서 ArticleRepository에서 사용할 생성자를 직접 만들어 준다.
    public Article(String title, String body){
        this.title=title;
        this.body=body;
    }
}
