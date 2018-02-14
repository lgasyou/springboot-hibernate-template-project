package com.xenon.entrance.controller;

import com.xenon.entrance.entity.User;
import com.xenon.entrance.service.UserService;
import com.xenon.entrance.util.ControllerUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/info")
    public String getUsers() {
        return userService.getUsers().toString();
    }

    @RequestMapping("/add")
    public Object add(@RequestParam String username) {
        User user = userService.add(username);
        Map<String, Object> result = ControllerUtil.generateReturnValue(user != null);
        result.put("user", user);
        return result;
    }

}
