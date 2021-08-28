package com.flamingo.junit5test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * @author flamingo
 * @create 7/6/21 9:28 AM
 */
@Data
@Builder
@TableName("user")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String password;
}
