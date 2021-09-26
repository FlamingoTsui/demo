package me.flamingo.demo.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import static org.junit.jupiter.api.Assertions.*;
@EnableAspectJAutoProxy
@SpringBootTest
class MovieTest {

    @Autowired
    private Performance movie;

    @Test
    void perform() {
        System.out.println("测试开始");
        movie.perform("<爱你三千遍>");
        System.out.println("测试结束");
    }
}