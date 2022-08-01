package com.hhchen.springbootec.service;

import com.hhchen.springbootec.dto.UserLoginRequest;
import com.hhchen.springbootec.dto.UserRegisterRequest;
import com.hhchen.springbootec.model.User;

public interface UserService {

    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User login(UserLoginRequest userLoginRequest);
}
