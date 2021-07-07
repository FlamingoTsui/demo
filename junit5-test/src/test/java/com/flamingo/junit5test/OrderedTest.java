package com.flamingo.junit5test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author flamingo
 * @create 7/7/21 2:43 PM
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTest {
    @Order(7)
    @Test
    public void aMethod() {
        System.out.println("A Method");
        assertEquals(1, 1);
    }

    @Order(2)
    @Test
    @Disabled
    public void bMethod() {
        System.out.println("B Method");
        assertEquals(1, 1);
    }

    @Order(3)
    @Test
    public void cMethod() {
        System.out.println("C Method");
        assertEquals(1, 1);
    }

    @Order(4)
    @Test
    public void dMethod() {
        System.out.println("D Method");
        assertEquals(1, 1);
    }
}
