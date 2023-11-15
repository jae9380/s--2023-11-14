package com.example.sb20231114.domain.article.article.repository;

import com.example.sb20231114.domain.article.article.entity.Article;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ArticleArrayList extends ArrayList<Article> {
// ArticleArrayList는 ArrayList를 상속하기 떄문에 ArrayList와 차이가 없다
}
