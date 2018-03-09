package com.xenonwebsite.api.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Value("${file.root.path}")
    private String ROOT_PATH;

    public void download(String url, HttpServletResponse response) throws IOException {
        InputStream is = new FileInputStream(ROOT_PATH + url);
        IOUtils.copy(is, response.getOutputStream());
        response.flushBuffer();
    }

    public String upload(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        File file = new File(ROOT_PATH + fileName);

        boolean directoryExists = !file.getParentFile().exists() && file.getParentFile().mkdirs();
        if (directoryExists) {
            multipartFile.transferTo(file);
            return fileName;
        }
        return null;
    }

    // Returns file urls.
    public List<String> upload(List<MultipartFile> files) throws IOException {
        List<String> urls = new ArrayList<>();
        for (MultipartFile uploadFile : files) {
            String fileName = upload(uploadFile);
            urls.add(fileName);
        }
        return urls;
    }

}
