package com.yang.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.yang.dto.User;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2024/03/26/14:03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/query")
    public R<User> queryUser(@RequestBody User user) {
        return userService.queryUser(user);
    }

    @PostMapping("/save")
    public R savUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
