package com.flamingo.multidatasourcewithmybatis.dao.foo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flamingo.multidatasourcewithmybatis.entity.foo.Foo;
import org.springframework.stereotype.Repository;

/**
 * @author flamingo
 * @create 7/6/21 2:23 PM
 */
@Repository
public interface FooDao extends BaseMapper<Foo> {
}
