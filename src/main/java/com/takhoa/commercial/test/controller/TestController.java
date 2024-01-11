package com.takhoa.commercial.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String test3() {
        return "111111";
    }

    @GetMapping("1")
    public String test() {
        return "111111";
    }

    @GetMapping("2")
    public String test1() {
        return "22222";
    }
}
