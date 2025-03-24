package org.itstep.first.modules.files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/first_files")
public class FirstFileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FirstFileUploadController.class);


    @GetMapping
    public String index() {
        return "first_files/index";
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file) {

        logger.info("Received file: {}", file.getOriginalFilename());
        logger.info("File size: {}", file.getSize());
        logger.info("File content type: {}", file.getContentType());
        logger.info("File Name: {}", file.getName());

        return "first_files/index";
    }
}
