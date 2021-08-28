package com.flamingo.junit5test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flamingo.junit5test.entity.UserDO;
import com.flamingo.junit5test.service.UserService;
import com.flamingo.junit5test.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
@DisplayName("用户注册登录测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @BeforeAll
    public void setUp() throws Exception {
        log.info("测试开始");
        // 初始化Mockito，或者junit4中使用@Runwith(MockitoJunitRunner.class)
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @Order(1)
    void hello() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    @Order(2)
    void signUp() throws Exception{
        UserDO userDO = UserDO.builder().name("张三").password("张三的密码").build();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/signUp")
                .contentType(MediaType.APPLICATION_JSON)
                .content(MAPPER.writeValueAsString(userDO));

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("【用户注册】{}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    @Order(3)
    void signIn() throws Exception{
        UserDO userDO = UserDO.builder().name("张三").password("张三的密码").build();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/signIn")
                .contentType(MediaType.APPLICATION_JSON)
                .content(MAPPER.writeValueAsString(userDO));

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        log.info("【用户登录】{}", mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testControllerSignIn() throws Exception{
        // 创建返回的模拟用户数据：赵六
        UserDO mockUser = UserDO.builder().name("赵六").password("赵六的密码").build();
        // 对方法调用service时进行mock处理
        Mockito.when(userService.signIn(Mockito.anyString(), Mockito.anyString()))
                .thenReturn("赵六，欢迎回来");

        // 测试的方法执行登录操作获得mock数据返回
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/signIn")
                .contentType(MediaType.APPLICATION_JSON)
                .content(MAPPER.writeValueAsString(mockUser));

        MvcResult mvcResult = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        log.info("【用户登录】{}", mvcResult.getResponse().getContentAsString());

        String result = userController.signIn(mockUser);
        log.info("【Mock用户登录】{}", result);
    }
}