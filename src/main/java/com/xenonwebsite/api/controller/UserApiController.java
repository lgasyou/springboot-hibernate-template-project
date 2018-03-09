package com.xenonwebsite.api.controller;

import com.xenonwebsite.api.entity.User;
import com.xenonwebsite.api.service.UserService;
import com.xenonwebsite.api.util.ApiControllerUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserApiController {

    @Resource
    private UserService userService;

    // 通过id获取用户信息
    @GetMapping("/users/{id}")
    public Object getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public Object addUserByUsername(@RequestParam String username) {
        User user = userService.add(username);
        boolean isSuccessful = user != null;
        Map<String, Object> result = ApiControllerUtil.generateStatus(isSuccessful);
        if (isSuccessful) {
            result.put("user", user);
        }
        return result;
    }

}
