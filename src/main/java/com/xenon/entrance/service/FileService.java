package com.xenon.entrance.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Value("${file.root.path}")
    private String ROOT_PATH;

    public byte[] download(String url) throws IOException {
        try (FileChannel fc = new RandomAccessFile(ROOT_PATH + "/" + url, "r").getChannel()) {
            MappedByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0,
                    fc.size()).load();
            byte[] result = new byte[(int) fc.size()];
            if (byteBuffer.remaining() > 0) {
                byteBuffer.get(result, 0, byteBuffer.remaining());
            }
            return result;
        }
    }

    // Returns file urls.
    public List<String> upload(List<MultipartFile> files) throws IOException {
        String filePath = "";

        List<String> urls = new ArrayList<>();
        for (MultipartFile uploadFile : files) {
            String fileName = uploadFile.getOriginalFilename();
            File file = new File(ROOT_PATH + "/" + filePath + fileName);

            boolean directoryExists = !file.getParentFile().exists() && file.getParentFile().mkdirs();
            if (directoryExists) {
                uploadFile.transferTo(file);
                urls.add(filePath + fileName);
            }
        }
        return urls;
    }

}
