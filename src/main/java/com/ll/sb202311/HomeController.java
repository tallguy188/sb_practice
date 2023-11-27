package com.ll.sb202311;

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
    String showMain() {
        return "안녕하세요";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout() {
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")
    @ResponseBody
    String showCalc(int a, int b) {
        return "계산 결과 : %d".formatted(a+b);
    }

    @GetMapping("/calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b) {
        return "계산기 2";
    }

    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(
            @RequestParam(defaultValue = "0") int a,  // 값이 없을때 0으로 설정
            @RequestParam(defaultValue = "0") int b
    ) {
        return "계산 결과 : %d".formatted(a + b);
    }

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "0") double a,
            @RequestParam(defaultValue = "0") double b
    ) {
        return "계산 결과 : %f".formatted(a + b);
    }

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc4(
            @RequestParam(defaultValue = "-") String a,
            @RequestParam(defaultValue = "-") String b
    ) {
        return "계산 결과 : %s".formatted(a + b);
    }

    @GetMapping("/calc7")
    @ResponseBody
    boolean showCalc7(
            int a, int b
    ) {
        return a > b;
    }
    @GetMapping("/calc8")
    @ResponseBody

    Person showCalc8(          // return이 그대로 렌더링되는 것이 아니라 springboot가 자체해석해서 json값으로 렌더링해준다는 것을 배움

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

        // 다수의 문자열을 이어붙일때는 StringBuilder를 사용
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

    @GetMapping("/calc18")// calc 14 ~ 18의 결과는 같음
    @ResponseBody
    String showCalc18() {
        // 이스케이프시퀀스를 쓰고싶지 않으면 """를 써라.
        String html = """
                <div>
                    <input type="text" placeholder="내용" value="반가워요.">
                </div>
                """;

        return html;
    }

    @GetMapping("/calc19")
    @ResponseBody
    String showCalc19(  // MVC에서 view로 넘기지 않으면 이렇게 html을 길게 써야되는 상황이 된다.
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
