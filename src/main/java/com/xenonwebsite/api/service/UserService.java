package com.xenonwebsite.api.service;

import com.xenonwebsite.api.dao.UserDao;
import com.xenonwebsite.api.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public List<User> getUsers() {
        return userDao.findAll();
    }

    public User add(String username) {
        User user = new User();
        user.setUsername(username);
        return userDao.insert(user);
    }

}
