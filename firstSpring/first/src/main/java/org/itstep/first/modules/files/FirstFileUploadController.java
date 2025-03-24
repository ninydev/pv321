package org.itstep.first.modules.files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping("/first_files")
public class FirstFileUploadController {

    @Value("${storage.private}")
    private String storagePrivate;

    @Value("${storage.private}")
    private String storagePublic;


    private static final Logger logger = LoggerFactory.getLogger(FirstFileUploadController.class);


    @GetMapping
    public String index() {
        return "first_files/index";
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {

//        logger.info("Absolute Temp Path: {}",  file.getResource().getFile().getPath());
//
//        try {
//            Thread.currentThread().sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        logger.info("Received file: {}", file.getOriginalFilename());
        logger.info("File size: {}", file.getSize());
        logger.info("File content type: {}", file.getContentType());

        logger.info("System temp dir: {}", System.getProperty("java.io.tmpdir"));
        logger.info("Tomcat temp dir: {}", System.getProperty("catalina.base") + "/temp");

        // Создание папки, если её нет
        File directory = new File(storagePrivate);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Генерация пути сохранения
        Path filePath = Path.of(storagePrivate, file.getOriginalFilename());

        try {
            // Сохранение файла
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            return "Ошибка загрузки файла";
        }

        return "first_files/index";
    }
}
