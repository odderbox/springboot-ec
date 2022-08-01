package com.hhchen.springbootec.service.impl;

import com.hhchen.springbootec.dao.UserDao;
import com.hhchen.springbootec.dto.UserLoginRequest;
import com.hhchen.springbootec.dto.UserRegisterRequest;
import com.hhchen.springbootec.model.User;
import com.hhchen.springbootec.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        // 檢查註冊的Email
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());

        if(user != null){
            log.warn("該email {} 已經被註冊", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 使用 MD5 生成密碼的雜湊值
        String hashedPassword = DigestUtils.md5DigestAsHex(userRegisterRequest.getPassword().getBytes());
        userRegisterRequest.setPassword(hashedPassword);

        //創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    public User login(UserLoginRequest userLoginRequest){
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        // 檢查User 是否存在
        if(user == null){
            log.warn("該Email {} 尚未註冊",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else{
            // 使用 MD5 生成密碼的雜湊值
            String hashedPassword = DigestUtils.md5DigestAsHex(userLoginRequest.getPassword().getBytes());
            //比較密碼是否正確
            if(user.getPassword().equals(hashedPassword)) {
                return user;
            }else{
                log.warn("此email {} 的密碼不正確",userLoginRequest.getEmail());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
