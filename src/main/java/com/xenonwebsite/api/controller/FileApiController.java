package com.xenonwebsite.api.controller;

import com.xenonwebsite.api.service.FileService;
import com.xenonwebsite.api.util.ApiControllerUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class FileApiController {

    @Resource
    private FileService fileService;

    // 通过URL下载文件
    @GetMapping("/files/{url:.+}")
    public void download(
            @PathVariable("url") String url,
            HttpServletResponse response) throws IOException {
        fileService.download(url, response);
    }

    // 上传单一文件
    @PostMapping("/files")
    public Object upload(@RequestParam MultipartFile file) throws IOException {
        String url = fileService.upload(file);
        boolean isSuccessful = url != null;
        Map<String, Object> ret = ApiControllerUtil.generateStatus(isSuccessful);
        if (isSuccessful) {
            ret.put("url", url);
        }
        return ret;
    }

}
