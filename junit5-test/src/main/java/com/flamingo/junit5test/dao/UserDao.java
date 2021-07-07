package com.flamingo.junit5test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flamingo.junit5test.entity.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author flamingo
 * @create 7/7/21 5:16 PM
 */
@Repository
public interface UserDao extends BaseMapper<UserDO> {
}
