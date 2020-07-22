package com.lennon.springbootdemo.repository;

import com.lennon.springbootdemo.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public User getUserById(long id) {
        User user = new User(20200717024001L, "lennon", 29);
        return user;
    }
}
