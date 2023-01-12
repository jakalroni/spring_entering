package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    // 위에 spring!!!을 model로 담아서 렌더링한 것과는 다르게, 파라미터로 입력받은 문자열을 model로 담기
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;  //데이터인 "hello spring!!!"이 그대로 출력됨(html 없음)
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello(); // ctrl + shift + enter: 세미콜론 닫고 마무리 단축키
        hello.setName(name);
        return hello; // 객체 리턴
    }

    static class Hello {
        private String name;

        // getter, setter 생성 단축키: alt + insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
