package com.xenon.xenonweb.controller;

import com.xenon.xenonweb.service.FileService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FileController {

    @Resource
    private FileService fileService;

    // Downloads one file by its url.
    @RequestMapping(value = "/download/{url:.+}", method = RequestMethod.GET)
    public void downloadFile(
            @PathVariable("url") String url,
            HttpServletResponse response) {
        try {
            fileService.download(url, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
