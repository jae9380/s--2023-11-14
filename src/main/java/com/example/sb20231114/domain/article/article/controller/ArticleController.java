package com.example.sb20231114.domain.article.article.controller;

import com.example.sb20231114.domain.article.article.entity.Article;
import com.example.sb20231114.domain.article.article.service.ArticleService;
import com.example.sb20231114.global.rsData.RsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired // 필드 주입 , final을 빼야 함
    private ArticleService articleService; // 상식적으로 =new ~~() 해줘야 하지만, 자동으로 연결해준다
    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData write(String title, String body) {
        Article article=articleService.write(title,body);
        RsData<Article> rs = new RsData<>(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),
                article
        );
        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle() {
        return articleService.findLastArticle();
    }
    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articleService.finAll();
    }
}

