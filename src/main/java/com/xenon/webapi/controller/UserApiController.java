package com.xenon.webapi.controller;

import com.xenon.webapi.entity.User;
import com.xenon.webapi.service.UserService;
import com.xenon.webapi.util.ApiControllerUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getUsers() {
        return userService.getUsers().toString();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestParam String username) {
        User user = userService.add(username);
        boolean isSuccessful = user != null;
        Map<String, Object> result = ApiControllerUtil.generateReturnValue(isSuccessful);
        if (isSuccessful) {
            result.put("user", user);
        }
        return result;
    }

}
