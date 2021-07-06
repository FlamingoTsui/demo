package com.flamingo.multidatasourcewithmybatis.entity.bar;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flamingo.multidatasourcewithmybatis.entity.BaseEntity;
import lombok.Builder;
import lombok.Data;

/**
 * @author flamingo
 * @create 7/6/21 2:20 PM
 */
@Data
@Builder
@TableName("t_bar")
public class Bar extends BaseEntity<Long> {
    private String barName;
    private String barValue;
}
