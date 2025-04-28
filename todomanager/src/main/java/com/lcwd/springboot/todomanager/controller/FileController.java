package com.lcwd.springboot.todomanager.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/file")
public class FileController {

    Logger logger = LoggerFactory.getLogger(FileController.class);

    @PostMapping("/upload-image")
    public String uploadimage(@RequestParam("image")MultipartFile file){
        logger.info("File name {} ", file.getName());
        logger.info("Original File name {} ", file.getOriginalFilename());
        logger.info("File content Type {} ", file.getContentType());
        logger.info("File Size {} ", file.getSize());
        return "File Saved Successful";
    }

    @PostMapping("/upload-file")
    public String uploadFile(@RequestParam("file") MultipartFile[] files){
        Arrays.stream(files).forEach(
                file -> {
                    logger.info("Original File name {} ", file.getOriginalFilename());
                    logger.info("File content Type {} ", file.getContentType());
                    logger.info("File Size {} ", file.getSize());
                }
        );
        return "File Saved Successful";
    }

    @GetMapping("/serve-image")
    public void serveImageHandler(HttpServletResponse response){
        try {
            FileInputStream fileInputStream = new FileInputStream("images/java-roadmap.jpg");
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(fileInputStream,response.getOutputStream());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
