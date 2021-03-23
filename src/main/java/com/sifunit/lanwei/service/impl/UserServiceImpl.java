package com.sifunit.lanwei.service.impl;

import com.sifunit.lanwei.domain.Role;
import com.sifunit.lanwei.domain.User;
import com.sifunit.lanwei.mapper.IBaseMapper;
import com.sifunit.lanwei.mapper.UserMapper;
import com.sifunit.lanwei.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByUsername(String username) {
        return userMapper. selectByUsername(username);
    }

    @Override
    public IBaseMapper<User> getMapper() {
        return userMapper;
    }
}
