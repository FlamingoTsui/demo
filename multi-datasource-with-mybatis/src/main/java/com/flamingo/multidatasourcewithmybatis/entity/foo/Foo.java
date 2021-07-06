package com.flamingo.multidatasourcewithmybatis.entity.foo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flamingo.multidatasourcewithmybatis.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;

/**
 * @author flamingo
 * @create 7/6/21 2:21 PM
 */
@Data
@Builder
@TableName("t_foo")
public class Foo extends BaseEntity<Long> {
    private String fooName;
    private String fooValue;
}
