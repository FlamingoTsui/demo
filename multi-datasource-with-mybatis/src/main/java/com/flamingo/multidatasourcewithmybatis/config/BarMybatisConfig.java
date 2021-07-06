package com.flamingo.multidatasourcewithmybatis.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.TypeHandler;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author flamingo
 * @create 7/6/21 11:20 AM
 */
@Configuration
@MapperScan(value = "com.flamingo.multidatasourcewithmybatis.dao.bar", sqlSessionFactoryRef = "barSqlSessionFactory",
sqlSessionTemplateRef = "barSqlSessionTemplate")
public class BarMybatisConfig implements InitializingBean {

    private ObjectProvider<Interceptor[]> interceptorsProvider;
    private ObjectProvider<TypeHandler[]> typeHandlersProvider;
    private ObjectProvider<LanguageDriver[]> languageDriversProvider;
    private ResourceLoader resourceLoader;
    private ObjectProvider<DatabaseIdProvider> databaseIdProvider;
    private ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider;
    private ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider;
    private ApplicationContext applicationContext;

    private MybatisPlusAutoConfiguration delegate;

    public BarMybatisConfig(ObjectProvider<Interceptor[]> interceptorsProvider,
                            ObjectProvider<TypeHandler[]> typeHandlersProvider, ObjectProvider<LanguageDriver[]> languageDriversProvider,
                            ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider,
                            ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider,
                            ObjectProvider<List<MybatisPlusPropertiesCustomizer>> mybatisPlusPropertiesCustomizerProvider,
                            ApplicationContext applicationContext) {
        this.interceptorsProvider = interceptorsProvider;
        this.typeHandlersProvider = typeHandlersProvider;
        this.languageDriversProvider = languageDriversProvider;
        this.resourceLoader = resourceLoader;
        this.databaseIdProvider = databaseIdProvider;
        this.configurationCustomizersProvider = configurationCustomizersProvider;
        this.mybatisPlusPropertiesCustomizerProvider = mybatisPlusPropertiesCustomizerProvider;
        this.applicationContext = applicationContext;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.bar")
    public DataSource barDataSource() {return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory barSqlSessionFactory(@Qualifier("barDataSource") DataSource barDataSource) throws Exception{
        return this.delegate.sqlSessionFactory(barDataSource);
    }

    @Bean
    public SqlSessionTemplate barSqlSessionTemplate(@Qualifier("barSqlSessionFactory") SqlSessionFactory barSqlSessionFactory) {
        return this.delegate.sqlSessionTemplate(barSqlSessionFactory);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        final MybatisPlusProperties properties = new MybatisPlusProperties();
        properties.setMapperLocations(new String[] {"classpath:mapper/bar/**/*.xml"});
        final MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setMapUnderscoreToCamelCase(true);
        properties.setConfiguration(configuration);

        this.delegate = new MybatisPlusAutoConfiguration(properties, this.interceptorsProvider,
                this.typeHandlersProvider, this.languageDriversProvider, this.resourceLoader, this.databaseIdProvider,
                this.configurationCustomizersProvider, this.mybatisPlusPropertiesCustomizerProvider,
                this.applicationContext);
        this.delegate.afterPropertiesSet();
    }
}
