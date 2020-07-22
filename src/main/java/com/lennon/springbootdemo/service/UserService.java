package com.lennon.springbootdemo.service;

import com.lennon.springbootdemo.domain.User;
import com.lennon.springbootdemo.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findUserByUserId(long id) {
        return userDao.getUserById(id);
    }
}
