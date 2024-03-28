package com.yang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.dto.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2024/03/26/13:43
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
