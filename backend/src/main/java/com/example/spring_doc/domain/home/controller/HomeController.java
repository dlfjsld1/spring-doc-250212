package com.example.spring_doc.domain.home.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Tag는 swagger에서 해당 컨트롤러에 대한 설명을 추가하는 어노테이션
@Tag(name = "HomeController", description = "API 서버 홈")
@Controller
public class HomeController {
    //@Operation은 swagger에서 해당 메서드에 대한 설명을 추가하는 어노테이션swagger 설정
    @Operation(summary = "API 서버 시작페이지", description = "API 서버 시작페이지입니다. API 호출은 인증을 해주세요")
    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "API 서버에 오신 걸 환영합니다.";
    }

}
