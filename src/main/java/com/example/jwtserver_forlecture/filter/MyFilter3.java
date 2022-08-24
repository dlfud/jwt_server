package com.example.jwtserver_forlecture.filter;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyFilter3 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        // 토큰을 만들었다고 가정함
        // 토큰 : abcde
        if(req.getMethod().equals("POST")) {
            String headerAuth = req.getHeader("Authorization");

            System.out.println(headerAuth);
            Map<String, Object> errorDetails = new HashMap<>();
            errorDetails.put("message", "Invalid token");

            if(headerAuth.equals("abcde")) {
                chain.doFilter(req, res);
            } else {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(res.getOutputStream(), errorDetails);
            }
        }



        chain.doFilter(req, res);

    }


}
