package com.lennon.springbootdemo.service;

import com.lennon.springbootdemo.domain.User;

import com.lennon.springbootdemo.repository.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    
    @MockBean
    private UserDao userDao;

    @Test
    public void findUserByIdTest(){
        when(userDao.getUserById(1001)).thenReturn(new User(20200717024001L, "lennon", 30));
        User expectUser = new User(20200717024001L, "lennon", 29);
        User user = userService.findUserByUserId(1001);
        assertEquals(expectUser.getName(),user.getName());
    }
}
