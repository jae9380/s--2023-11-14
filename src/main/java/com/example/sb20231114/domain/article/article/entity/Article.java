package com.example.sb20231114.domain.article.article.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Article {
    private long id;
    private String title, body;
}
