package com.shakti.springsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest")
public class HomeController {
    @RequestMapping("/old")
    public String hello(){
        return "hello old ones";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/secured/all")
    public String securedShow(){
        return "secured ones !";
    }
}
