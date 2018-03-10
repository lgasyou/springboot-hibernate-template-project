package com.xenonwebsite.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    /*
     * GET方法将获取登录页面
     * POST方法将调用认证API
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
