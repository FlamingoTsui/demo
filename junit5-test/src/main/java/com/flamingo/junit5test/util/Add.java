package com.flamingo.junit5test.util;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author flamingo
 * @create 7/6/21 10:49 PM
 */
public class Add {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Set<String> productSet = new HashSet<>();
//        productSet.add("ccb");
//        productSet.add("remark");
//        productSet.add("spdb");
        System.out.println(String.join(",", productSet));

    }
}
