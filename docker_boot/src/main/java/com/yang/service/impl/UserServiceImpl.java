package com.yang.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.yang.dto.User;
import com.yang.mapper.UserMapper;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2024/03/26/13:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public R<User> queryUser(User user) {
        String userJsonStr = (String) redisTemplate.opsForValue().get(user.getId());
        if(!StringUtils.isEmpty(userJsonStr)){
            User user1 = JSONObject.toJavaObject(JSONObject.parseObject(userJsonStr), User.class);
            return R.ok(user1);
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().eq(User::getId, user.getId());
        User user1 = userMapper.selectOne(queryWrapper);
        if(!Objects.isNull(user1)){
            redisTemplate.opsForValue().set(user.getId(),JSONObject.toJSONString(user1));
        }
        return R.ok(user1);
    }

    @Override
    public R saveUser(User user){
        userMapper.insert(user);
        return R.ok("保存成功");
    }
}
