package com.flamingo.junit5test.controller;

import com.flamingo.junit5test.entity.UserDO;
import com.flamingo.junit5test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author flamingo
 * @create 7/7/21 5:18 PM
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String hello() {
        log.info("Some one visit this web.");
        return "Welcome to my web! Please sign up or sign in! ";
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody UserDO userDO) {}

    @PostMapping("/signIn")
    public void signIn(@RequestBody UserDO userDO) {}
}
