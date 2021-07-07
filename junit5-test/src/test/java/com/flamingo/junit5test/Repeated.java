package com.flamingo.junit5test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

/**
 * @author flamingo
 * @create 7/7/21 11:53 AM
 */
public class Repeated {
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    @DisplayName("repeatTest")
    void repeatedTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        //我们可以通过TestInfo在测试中获取测试的相关信息，比如输出自定义的测试名
        System.out.println(testInfo.getDisplayName());
        //输出当前重复次数
        System.out.println("currentRepetition:"+repetitionInfo.getCurrentRepetition());
    }
}
