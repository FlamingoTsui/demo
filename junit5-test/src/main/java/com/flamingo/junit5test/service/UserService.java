package com.flamingo.junit5test.service;

/**
 * @author flamingo
 * @create 7/7/21 5:17 PM
 */
public interface UserService {
    /** 用户注册 */
    String signUp(String name, String passwd);
    /** 用户登录 */
    String signIn(String name, String passwd);
}
