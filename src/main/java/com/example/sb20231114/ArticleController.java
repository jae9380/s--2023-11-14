package com.example.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ArticleController {
    private ArrayList<Article> articles = new ArrayList<>();
    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @GetMapping("/article/doWrite")
    @ResponseBody
    Map<String,Object> doWrite(String title, String body) {
        Map<String,Object>rs=new LinkedHashMap<>();
        // Map은 순서에는 상관이 없어서 LinkedHashMap은 순서를 기억한다
        Article article = new Article(articles.size()+1, title, body);
        rs.put("resultCode","S-1");
        rs.put("msg", "%d번 게시물이 작성되었습니다.".formatted(article.getId()));
        rs.put("data", article);
        articles.add(article);
        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(String title, String body) {
        return articles.getLast();
    }
    @GetMapping("/article/getArticles")
    @ResponseBody
    List<Article> getArticles() {
        return articles;
    }
}
@AllArgsConstructor
@Getter
class Article{
    private long id;
    private String title,body;
}