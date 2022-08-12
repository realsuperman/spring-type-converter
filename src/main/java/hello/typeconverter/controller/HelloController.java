package hello.typeconverter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
    @GetMapping("/hello-v1") // 기본적으로 날라오는 모든 파라미터는 문자열이다 문자열외에 값을 쓰려면 변환 필요
    public String helloV1(HttpServletRequest request){
        String data = request.getParameter("data"); // 문자 타입 조회
        Integer intValue = Integer.valueOf(data);
        System.out.println(intValue);
        return "ok";
    }
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data){
        System.out.println("data = "+data);
        return "ok";
    }
}
