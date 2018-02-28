package com.xenon.entrance.controller;

import com.xenon.entrance.service.FileService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class FileController {

    @Resource
    private FileService fileService;

    // Downloads one file by its url.
    @RequestMapping(value = "/download/{url:.+}", method = RequestMethod.GET)
    public byte[] downloadFile(@PathVariable("url") String url) {
        try {
            return fileService.download(url);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
