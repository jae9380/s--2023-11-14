package com.example.sb20231114.domain.article.article.controller;

import com.example.sb20231114.domain.article.article.entity.Article;
import com.example.sb20231114.domain.article.article.service.ArticleService;
import com.example.sb20231114.global.rsData.RsData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
// final 필드나 @Nonnull 어노테이션이 붙은 필드를 파라미터로 받는 생성자를 만들어준다
public class ArticleController {
    private final ArticleService articleService;

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
    @PostMapping("/article/write2")
    @SneakyThrows
    void write2(
//            전통적인 Servlet 방식은  아래 방식 처럼
//            Response를 가지면서 응답을 만들었으면 오브젝트 매퍼를 통해서 객체를 만들어야 한다
            HttpServletRequest req,
            HttpServletResponse resp

    ) {
        String title=req.getParameter("title"),
                body=req.getParameter("body");
        Article article=articleService.write(title,body);
        RsData<Article> rs = new RsData<>(
                "S-1",
                "%d번 게시물이 작성되었습니다.".formatted(article.getId()),
                article
        );
        ObjectMapper objectMapper = new ObjectMapper();
        // 한글 꺠지는 현상 고치기
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println(objectMapper.writeValueAsString(rs));
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

