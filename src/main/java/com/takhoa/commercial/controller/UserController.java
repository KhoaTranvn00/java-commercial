package com.takhoa.commercial.controller;

import com.takhoa.commercial.entity.User;
import com.takhoa.commercial.config.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/{username}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<User> getByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
}