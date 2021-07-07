package com.flamingo.junit5test.service;

import com.flamingo.junit5test.entity.UserDO;

/**
 * @author flamingo
 * @create 7/7/21 5:17 PM
 */
public interface UserService {
    Long add(UserDO userDO);
    UserDO findById(Long id);
    Long updateById(UserDO userDO);
    Long deleteById(Long id);
}
