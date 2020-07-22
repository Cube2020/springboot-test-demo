package com.lennon.springbootdemo.controller;

import com.lennon.springbootdemo.domain.User;
import com.lennon.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public User users(@PathVariable long id) {
        return userService.findUserByUserId(id);
    }
}
