package com.flamingo.junit5test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author flamingo
 * @create 7/7/21 8:59 AM
 */
public class AssertJSampleTest {

    @Test
    public void testUsingAssertJ() {
        // 字符串判断
        String s = "abcde";
        assertThat(s).as("字符串判断，判断首尾及长度").startsWith("a").endsWith("e").hasSize(5);
        // 数字判断
        Integer i = 50;
        assertThat(i).as("数字判断,数字大小比较").isGreaterThan(10).isLessThan(100);
        // 日期判断
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 100);
        Date date3 = new Date(date1.getTime() - 100);
        assertThat(date1).as("日期判断：日期大小比较").isBefore(date2).isAfter(date3);
        // list比较
        List<String> list = Arrays.asList("a", "b", "c", "d");
        assertThat(list).as("list的首尾元素及长度").startsWith("a").endsWith("d").hasSize(4);
        // Map判断
        Map<String, Object> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        assertThat(map).as("Map的长度及键值测试").hasSize(3).containsKeys("x cA","B","C");
    }
}
