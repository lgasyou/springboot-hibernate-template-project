package com.xenon.entrance.controller;

import com.xenon.entrance.service.RootService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RootController {

    @Resource
    private RootService rootService;

    @RequestMapping("/")
    public String root() {
        return rootService.hello();
    }

    @RequestMapping("/index")
    public String index() {
        return "deploy test";
    }

}
