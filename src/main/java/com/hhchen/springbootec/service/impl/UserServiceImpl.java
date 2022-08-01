package com.hhchen.springbootec.service.impl;

import com.hhchen.springbootec.dao.UserDao;
import com.hhchen.springbootec.dto.UserRegisterRequest;
import com.hhchen.springbootec.model.User;
import com.hhchen.springbootec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }
}
