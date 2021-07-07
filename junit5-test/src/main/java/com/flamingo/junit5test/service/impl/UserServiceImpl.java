package com.flamingo.junit5test.service.impl;

import com.flamingo.junit5test.dao.UserDao;
import com.flamingo.junit5test.entity.UserDO;
import com.flamingo.junit5test.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author flamingo
 * @create 7/7/21 5:17 PM
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Long add(UserDO userDO) {
        return null;
    }

    @Override
    public UserDO findById(Long id) {
        return null;
    }

    @Override
    public Long updateById(UserDO userDO) {
        return null;
    }

    @Override
    public Long deleteById(Long id) {
        return null;
    }
}
