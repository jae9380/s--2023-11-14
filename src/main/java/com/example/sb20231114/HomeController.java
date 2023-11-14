package com.example.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
        // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showMain() {
        return "안녕하세요.";
    }

    @GetMapping("/about")
    @ResponseBody
    String showMAin() {
        return "<h1>개발자 커뮤니티 입니다.</h1>";
    }

    @GetMapping("/calc1")
    @ResponseBody
    String showClac1(int a, int b) {
        return "계산 결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc2")
    @ResponseBody
    String showClac2(Integer a, Integer b) {
        return "a : " + a + ", b :" + b;
    }

    @GetMapping("/calc3")
    @ResponseBody
        // 입력값을 안주면 0으로 계산
    String showCalc3(
            @RequestParam(defaultValue = "0") int a,
            @RequestParam(defaultValue = "0") int b
    ) {
        return "계산 결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc4")
    @ResponseBody
        // /calc4?a=10&b=10.5입니다. 입력시 오류 발생
    String showCalc4(
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b
    ) {
        return "계산 결과 : %f".formatted(a + b);
    }

    @GetMapping("/calc5")
    @ResponseBody // a=안녕 ,b=하세요  결과= 안녕하세요
    String showCalc5(
            @RequestParam(defaultValue = "0") String a,
            @RequestParam(defaultValue = "0") String b
    ) {
        return "계산 결과 : %s".formatted(a + b);
    }
}