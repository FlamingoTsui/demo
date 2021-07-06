package com.flamingo.multidatasourcewithmybatis.controller;

import com.flamingo.multidatasourcewithmybatis.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author flamingo
 * @create 7/6/21 2:51 PM
 */
@RestController
@RequestMapping("/multiDataSource")
public class TestController {

    private TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/test")
    public void test() {
        testService.test();
    }
}
