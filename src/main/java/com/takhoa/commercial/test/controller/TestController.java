package com.takhoa.commercial.test.controller;

import com.takhoa.commercial.service.AuthenticateService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
    AuthenticateService authenticateService;

    @GetMapping
    public String test3() {
        return "111111";
    }

    @GetMapping("1")
    @PreAuthorize("hasAuthority('USER')")
    public String test() {
        return "111111";
    }

    @GetMapping("2")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String test1() {
        return "22222";
    }

    @GetMapping("author")
    public String getRole() {
        return authenticateService.getUserId();
    }
}
