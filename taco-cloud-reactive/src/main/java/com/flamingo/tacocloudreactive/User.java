package com.flamingo.tacocloudreactive;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @author flamingo
 * @create 9/6/21 6:11 PM
 */
@Data
@Table("user")
public class User {
    @Id
    private Long id;
    private String name;
    private String password;
}
