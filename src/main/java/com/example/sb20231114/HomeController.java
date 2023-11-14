package com.example.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/calc6")
    @ResponseBody
    // int 형태의 리턴값을 유지하여 브라우저에 전달하는 방법이 아닌 문자열로 전달이 된다
    int showCalc6(
            int a, int b
    ) {
        return a + b;
    }

    @GetMapping("/calc7")
    @ResponseBody
    // 논리값 또한 같다
    boolean showCalc7(
            int a, int b
    ) {
        return a > b;
    }

    @GetMapping("/calc8")
    @ResponseBody
    // String은 기본 타입이 아니기 때문에 값이 없으면 null이 들어가지만, int는 값을 줘야한다
    // 해당 객체는 json방식으로 저장이 된다
    Person showCalc8(
            String name, int age
    ) {
        return new Person(name, age);
    }

    @GetMapping("/calc9")
    @ResponseBody
    Person2 showCalc9(
            String name, int age
    ) {
        return new Person2(name, age);
    }

    @GetMapping("/calc10")
    @ResponseBody
    Map<String, Object> showCalc10(
            String name, int age
    ) {
        Map<String, Object> personMap = Map.of(
                "name", name,
                "age", age
        );

        return personMap;
    }

    @GetMapping("/calc11")
    @ResponseBody
    // list 또한 json 방식으로 저장된다
    List<Integer> showCalc11() {
        List<Integer> nums = new ArrayList<>() {{
            add(10);
            add(-510);
            add(10010);
        }};

        return nums;
    }

    @GetMapping("/calc12")
    @ResponseBody
    // 동일
    int[] showCalc12() {
        int[] nums = new int[]{10, -510, 10010};

        return nums;
    }

    @GetMapping("/calc13")
    @ResponseBody
    List<Person2> showCalc13(
            String name, int age
    ) {
        List<Person2> persons = new ArrayList<>() {{
            add(new Person2(name, age));
            add(new Person2(name + "!", age + 1));
            add(new Person2(name + "!!", age + 2));
        }};

        return persons;
    }

    /*
     문자열 (JSON)
     150 => "150"
     true => "true"
     'a' => "a"
     객체를 문자열로 변환 할 때 JSON이라는 표준 방식을 따른다.
    */

    @GetMapping("/calc14")
    @ResponseBody
    String showCalc14() {
        String html = "";

        html += "<div>";
        html += "<input type=\"text\" placeholder=\"내용\">";
        html += "</div>";

        return html;
    }

    @GetMapping("/calc15")
    @ResponseBody
    String showCalc15() {
        StringBuilder sb = new StringBuilder();

        sb.append("<div>");
        sb.append("<input type=\"text\" placeholder=\"내용\">");
        sb.append("</div>");

        return sb.toString();
    }

    @GetMapping("/calc16")
    @ResponseBody
    String showCalc16() {
        String html = "<div><input type=\"text\" placeholder=\"내용\"></div>";

        return html;
    }

    @GetMapping("/calc17")
    @ResponseBody
    String showCalc17() {
        String html = """
                <div>
                    <input type="text" placeholder="내용">
                </div>
                """;

        return html;
    }

    @GetMapping("/calc18")
    @ResponseBody
    String showCalc18() {
        String html = """
                <div>
                    <input type="text" placeholder="내용" value="반가워요.">
                </div>
                """;

        return html;
    }

    @GetMapping("/calc19")
    @ResponseBody
    String showCalc19(
            @RequestParam(defaultValue = "") String subject,
            @RequestParam(defaultValue = "") String content
    ) {
        String html = """
                <div>
                    <input type="text" placeholder="제목" value="%s">
                </div>
                <div>
                    <input type="text" placeholder="내용" value="%s">
                </div>
                """.formatted(subject, content);

        return html;
    }

    @GetMapping("/calc20")
    String showCalc20() {
        return "calc20";
    }

    @GetMapping("/calc21")
    String showCalc21(Model model) {
        model.addAttribute("v1", "안녕");
        model.addAttribute("v2", "반가워");
        return "calc21";
    }
}

@AllArgsConstructor
class Person {
    public String name;
    public int age;
}

@AllArgsConstructor
class Person2 {
    @Getter
    private String name;
    @Getter
    private int age;
}