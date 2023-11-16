package com.example.sb20231114.domain.article.article.controller;

import com.example.sb20231114.domain.article.article.entity.Article;
import com.example.sb20231114.domain.article.article.service.ArticleService;
import com.example.sb20231114.global.rq.Rq;
import com.example.sb20231114.global.rsData.RsData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
// final 필드나 @Nonnull 어노테이션이 붙은 필드를 파라미터로 받는 생성자를 만들어준다
@Validated // 메소드에 @NotBlank 사용 가능해진다
public class ArticleController {
    private final ArticleService articleService;
    private final Rq rq;

    @GetMapping("/article/write")
    String showWrite() {
        return "article/write";
    }

    @PostMapping("/article/write")
    @ResponseBody
    RsData write( @NotBlank(message = "제목좀..") String title,
                  @NotBlank String body) {
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

    @GetMapping("/article/articleServicePointer")
    @ResponseBody
    String articleServicePointer(){
        return articleService.toString();
        // 객체를 계속 만들지 않고 하나를 만들어 계속 재활용 하고있다.
    }
    @GetMapping("/article/httpServletRequestPointer")
    @ResponseBody
    String httpServletRequestPointer(HttpServletRequest req){
        return req.toString();
    }
    // Request와Response는 계속 값이 바뀐다.
    // 해당 객체는 필요할 떄 잠시 생기고 사라진다.
    @GetMapping("/article/httpServletResponsePointer")
    @ResponseBody
    String httpServletResponsePointer(HttpServletResponse resp){
        return resp.toString();
    }

    @GetMapping("/article/rqPointer")
    @ResponseBody
    String rqPointer(){
        return rq.toString();
    }

    @GetMapping("/article/rqTest")
    String showRqTest(Model model) {
        String rqToString = rq.toString();
        model.addAttribute("rqToString", rqToString);
        return "article/rqTest";
    }

}

