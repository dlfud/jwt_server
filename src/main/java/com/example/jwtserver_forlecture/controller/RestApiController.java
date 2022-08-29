package com.example.jwtserver_forlecture.controller;

import com.example.jwtserver_forlecture.dao.UserRepository;
import com.example.jwtserver_forlecture.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequiredArgsConstructor
public class RestApiController {


    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

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

    @PostMapping("join")
    public String join(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        userRepository.save(user);
        return "회원가입 완료";
    }

}
