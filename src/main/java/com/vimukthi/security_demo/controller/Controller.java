package com.vimukthi.security_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/home")
    public String hello(HttpServletRequest httpServletRequest){
        return "Hello "+ httpServletRequest.getSession().getId();
    }

}
