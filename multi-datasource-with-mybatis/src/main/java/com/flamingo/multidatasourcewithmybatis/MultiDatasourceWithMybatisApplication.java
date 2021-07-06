package com.flamingo.multidatasourcewithmybatis;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        MybatisPlusAutoConfiguration.class})
@Slf4j
public class MultiDatasourceWithMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiDatasourceWithMybatisApplication.class, args);
    }

}
