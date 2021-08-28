package com.flamingo.junit5test;

import com.flamingo.junit5test.dao.UserDao;
import com.flamingo.junit5test.entity.UserDO;
import com.flamingo.junit5test.service.UserService;
import com.flamingo.junit5test.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * @author flamingo
 * @create 8/28/21 12:49 AM
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class MockitoTest {
    // 需要测试的类，会创建真实实例
    @InjectMocks
    private UserServiceImpl userService;
    // 方法中依赖的类，会创建虚拟的mock
    @Mock
    private UserDao userDao;

    @BeforeAll
    public void setUp() throws Exception {
        log.info("测试开始");
        // 初始化Mockito，或者junit4中使用@Runwith(MockitoJunitRunner.class)
        MockitoAnnotations.openMocks(this);
    }
    @AfterAll
    public void tearDown() {
        log.info("测试结束");
    }

    @Test
    public void testServiceSignIn() {
        // 创建返回的模拟用户数据：王五
        UserDO mockUser = UserDO.builder().name("王五").password("王五的密码").build();
        // 对方法调用dao时进行mock处理
        Mockito.when(userDao.findByNameAndPasswd(Mockito.anyString(), Mockito.anyString()))
                .thenReturn(mockUser);

        // 测试的方法执行登录操作获得mock数据返回
        String result = userService.signIn("王五", "王五的密码");
        log.info("mock返回结果：{}", result);
        Assertions.assertEquals("王五，欢迎回来", result);
    }
}
