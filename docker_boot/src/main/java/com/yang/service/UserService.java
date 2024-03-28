package com.yang.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.yang.dto.User;

import java.util.List;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2024/03/26/13:42
 */
public interface UserService {
    R<User> queryUser(User user);
    R saveUser(User user);
}
