package com.backend.project.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class projectController {

  @GetMapping("/")
  String test() {
    return "test";
  }
}
