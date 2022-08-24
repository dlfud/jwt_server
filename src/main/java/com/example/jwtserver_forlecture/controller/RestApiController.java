package com.example.jwtserver_forlecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("")
public class RestApiController {

    @GetMapping("/home")
    @ResponseBody
    public String home() {
        return "home";
    }

    @PostMapping("/token")
    @ResponseBody
    public String token() {
        return "token";
    }

}
