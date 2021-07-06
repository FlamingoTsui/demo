package com.flamingo.multidatasourcewithmybatis.dao.bar;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flamingo.multidatasourcewithmybatis.entity.bar.Bar;
import org.springframework.stereotype.Repository;

/**
 * @author flamingo
 * @create 7/6/21 2:22 PM
 */
@Repository
public interface BarDao extends BaseMapper<Bar> {
}
