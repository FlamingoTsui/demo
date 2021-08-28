package com.flamingo.junit5test.service.impl;

import com.flamingo.junit5test.dao.UserDao;
import com.flamingo.junit5test.entity.UserDO;
import com.flamingo.junit5test.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public String signUp(String name, String passwd) {
        UserDO user = userDao.findByName(name);
        if (Objects.nonNull(user)) {
            return "该用户已存在，请登录或重新注册";
        } else {
            UserDO newUser = UserDO.builder().name(name).password(passwd).build();
            userDao.insert(newUser);
            return name + "，欢迎使用";
        }
    }

    @Override
    public String signIn(String name, String passwd) {
        UserDO user = userDao.findByNameAndPasswd(name, passwd);
        if (Objects.nonNull(user)) {
            return name + "，欢迎回来";
        } else {
            return "用户名或密码不正确";
        }
    }
}
