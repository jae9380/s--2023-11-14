package com.example.sb20231114.global.rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
@RequestScope
// 하나의 리퀘스트가 오며는 그 잠시에만 만들어지고 사라진다.
// Rq가 계속 살아있어도 쓸모가 없다.
@Component
//@ApplicationScope
// 지금까지 만든 스코프는 어플리케이션 스코프다.
// 딱 한번만 만들고 이후에는 재활용

// @Component 붙였다고 모두 다 수명이 무한하지 않는다.
// @RequestScope 하면 해당 객체는 수명이 일시적이다.
// 그래서 계속 값이 달라진다.
public class Rq {
    private final HttpServletRequest req;
    private final HttpServletResponse resp;

    public Rq(HttpServletRequest req, HttpServletResponse resp) {
        this.req = req;
        this.resp = resp;
    }
}
