package com.xenon.webapi.service;

import com.xenon.webapi.dao.UserDao;
import com.xenon.webapi.entity.User;
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
