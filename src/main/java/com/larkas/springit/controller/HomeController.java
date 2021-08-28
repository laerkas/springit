package com.larkas.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String home(Model model, HttpServletRequest httpServletRequest) {
        model.addAttribute("msg", "lazzzor");
        return "indux";
    }
}
