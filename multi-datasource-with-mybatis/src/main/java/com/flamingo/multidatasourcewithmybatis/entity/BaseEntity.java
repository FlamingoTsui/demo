package com.flamingo.multidatasourcewithmybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author flamingo
 * @create 7/6/21 2:40 PM
 */
@Data
public abstract class BaseEntity<ID> {

    @TableId(type = IdType.AUTO)
    protected ID id;
}
