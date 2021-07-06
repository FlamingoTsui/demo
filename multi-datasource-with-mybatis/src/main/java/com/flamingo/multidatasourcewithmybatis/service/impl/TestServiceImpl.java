package com.flamingo.multidatasourcewithmybatis.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.flamingo.multidatasourcewithmybatis.dao.bar.BarDao;
import com.flamingo.multidatasourcewithmybatis.dao.foo.FooDao;
import com.flamingo.multidatasourcewithmybatis.entity.bar.Bar;
import com.flamingo.multidatasourcewithmybatis.entity.foo.Foo;
import com.flamingo.multidatasourcewithmybatis.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author flamingo
 * @create 7/6/21 2:28 PM
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    private BarDao barDao;
    private FooDao fooDao;

    public TestServiceImpl(BarDao barDao, FooDao fooDao) {
        this.barDao = barDao;
        this.fooDao = fooDao;
    }

    @Override
    public void test() {
        Bar bar = Bar.builder().barName("Tom")
                .barValue("tom123").build();
        Foo foo = Foo.builder().fooName("Jerry")
                .fooValue("jerry1234").build();

        barDao.insert(bar);
        fooDao.insert(foo);
        log.info("测试多数据源插入数据成功");
        log.info("查询到bar对象为：{}", barDao.selectById(1));
        log.info("查询到bar对象为：{}", fooDao.selectById(1));
    }
}
