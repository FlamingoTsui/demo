package com.flamingo.junit5test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.flamingo.junit5test.entity.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author flamingo
 * @create 7/7/21 5:16 PM
 */
@Repository
public interface UserDao extends BaseMapper<UserDO> {

    /** 通过姓名查找用户*/
    default UserDO findByName(String name) {
        return this.selectOne(Wrappers.lambdaQuery(UserDO.class).eq(UserDO::getName, name));
    }

    /** 通过姓名及密码查找用户*/
    default UserDO findByNameAndPasswd(String name, String passwd) {
        return this.selectOne(Wrappers.lambdaQuery(UserDO.class).eq(UserDO::getName, name).eq(UserDO::getPassword, passwd));
    }
}
