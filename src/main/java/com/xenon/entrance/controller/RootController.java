package com.xenon.entrance.controller;

import com.xenon.entrance.service.RootService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RootController {

    @Resource
    private RootService rootService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return rootService.hello();
    }

}
