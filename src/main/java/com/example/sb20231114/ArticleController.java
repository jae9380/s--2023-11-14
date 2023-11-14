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
    private Article lastArticle;
    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @GetMapping("/article/doWrite")
    @ResponseBody
    Map<String,Object> doWrite(String title, String body) {
        Map<String,Object>rs=new HashMap<>();
        lastArticle =new Article(1,title,body);
        rs.put("msg","1번 게시물이 작성되었습니다.");
        rs.put("data",lastArticle);
        return rs;
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    Article getLastArticle(String title, String body) {
        return lastArticle;
    }
}
@AllArgsConstructor
@Getter
class Article{
    private long id;
    private String title,body;
}