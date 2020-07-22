package com.lennon.springbootdemo.repository;

import com.lennon.springbootdemo.domain.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getUserByIdTest() {
        User expectedUser = new User(20200717024001L, "lennon", 29);
        User user = userDao.getUserById(20200717024001L);
        assertEquals(user.getName(), expectedUser.getName());
    }
}
