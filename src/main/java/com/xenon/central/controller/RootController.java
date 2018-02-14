package com.xenon.central.controller;

import com.xenon.central.service.RootService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RootController {

    @Resource
    private RootService rootService;

    @ResponseBody
    @RequestMapping("/")
    public String root() {
        return rootService.hello();
    }

    @ResponseBody
    @RequestMapping("/index")
    public String index() {
        return "tester";
    }

}
