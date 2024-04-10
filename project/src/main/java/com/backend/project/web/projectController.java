package com.backend.project.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class projectController {


  @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

  @GetMapping("/")
  String test() {
    return "test";
  }

  @GetMapping("/test")
  String test2() {
    return "test";
  }
}
