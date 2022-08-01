package com.hhchen.springbootec.dao;

import com.hhchen.springbootec.dto.UserRegisterRequest;
import com.hhchen.springbootec.model.User;

public interface UserDao {

    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
