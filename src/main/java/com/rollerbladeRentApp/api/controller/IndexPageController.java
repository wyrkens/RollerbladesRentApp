package com.rollerbladeRentApp.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class IndexPageController {
    @GetMapping("/")
    public ModelAndView displayIndexPage() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("currentDate", LocalDateTime.now().toString());
        return modelAndView;
    }
}
