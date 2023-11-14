package com.example.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ArticleController {
    private Article[] articles = new Article[3];
    private int articlesLastIndex = -1;
    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @GetMapping("/article/doWrite")
    @ResponseBody
    Map<String,Object> doWrite(String title, String body) {
        Map<String,Object>rs=new HashMap<>();
        Article article = new Article(articlesLastIndex + 2, title, body);
        rs.put("msg", "%d번 게시물이 작성되었습니다.".formatted(article.getId()));
        rs.put("data", article);
        articles[++articlesLastIndex] = article;
        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(String title, String body) {
        return articles[++articlesLastIndex];
    }
    @GetMapping("/article/getArticles")
    @ResponseBody
    Article[] getArticles() {
        return articles;
    }
}
@AllArgsConstructor
@Getter
class Article{
    private long id;
    private String title,body;
}