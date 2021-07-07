package com.flamingo.junit5test;

import com.flamingo.junit5test.util.Add;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 常用注解测试
 * @author flamingo
 * @create 7/6/21 11:04 PM
 */
@DisplayName("Common annotation test")
public class AnnotationsTest {
    private static Add add;

    @BeforeAll
    public static void beforeAll() {
        add = new Add();
        System.out.println("Run before all test methods run");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Run before each test method runs");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Run after each test method finishes running");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Run after all test methods have finished running");
    }

    @Disabled
    @Test
    @DisplayName("Ignore the test")
    public void disabledTest() {
        System.out.println("This test will not run");
    }

    @Test
    @DisplayName("Test Methods 1+1")
    public void testAdd1() {
        System.out.println("Running test method1+1");
        Assertions.assertEquals(2, add.add(1, 1));
    }

    @Test
    @DisplayName("Test Methods 2+2")
    public void testAdd2() {
        System.out.println("Running test method2+2");
        Assertions.assertEquals(4,add.add(2,2));
    }
}
