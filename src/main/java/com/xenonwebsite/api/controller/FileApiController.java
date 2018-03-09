package com.xenonwebsite.api.controller;

import com.xenonwebsite.api.service.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class FileApiController {

    @Resource
    private FileService fileService;

    // Downloads file
    @GetMapping("/files/{url:.+}")
    public void download(
            @PathVariable("url") String url,
            HttpServletResponse response) throws IOException {
        fileService.download(url, response);
    }

    // Uploads file
    @PostMapping("/files")
    public void upload(@RequestParam MultipartFile file) throws IOException {
        fileService.upload(file);
    }

}
