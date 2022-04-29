package com.nowcoder.community.service;

import com.nowcoder.community.mapper.UserMapper;
import com.nowcoder.community.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

   public User getUserById(Integer id) {
        return userMapper.selectById(id);
    }
}
