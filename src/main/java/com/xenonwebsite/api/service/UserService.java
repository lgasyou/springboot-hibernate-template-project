package com.xenonwebsite.api.service;

import com.xenonwebsite.api.dao.UserDao;
import com.xenonwebsite.api.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public User getUserById(Long id) {
        return userDao.findUserById(id);
    }

    public User add(String username) {
        User user = new User();
        user.setUsername(username);
        return userDao.save(user);
    }

}
