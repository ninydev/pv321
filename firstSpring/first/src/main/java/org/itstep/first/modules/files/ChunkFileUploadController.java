package org.itstep.first.modules.files;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Controller
@RequestMapping("/chunk_files")
public class ChunkFileUploadController {

    @Value("${storage.upload_dir}")
    private String UPLOAD_DIR;

    @Value("${storage.private}")
    private String storagePrivate;

    @GetMapping
    public String index() {
        return "chunk_files/index";
    }

//    @PostMapping
//    public String upload() {
//        return "chunk_files/index";
//    }


    @PostMapping()
    public ResponseEntity<String> uploadChunk(HttpServletRequest request,
                                              @RequestHeader("X-Chunk-Index") int chunkIndex,
                                              @RequestHeader("X-Total-Chunks") int totalChunks,
                                              @RequestHeader("X-File-Name") String fileName) {

        try {
            Path tempFile = Paths.get(UPLOAD_DIR, fileName + ".part" + chunkIndex);
            try (InputStream inputStream = request.getInputStream();
                 OutputStream outputStream = Files.newOutputStream(tempFile, StandardOpenOption.CREATE)) {
                inputStream.transferTo(outputStream);
            }

            if (chunkIndex == totalChunks - 1) {
                mergeChunks(fileName, totalChunks);
            }

            return ResponseEntity.ok("Chunk " + chunkIndex + " uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Failed to upload chunk");
        }
    }

    private void mergeChunks(String fileName, int totalChunks) throws IOException {
        Path finalFilePath = Paths.get(storagePrivate + "/big_files", fileName);
        try (OutputStream finalOutputStream = Files.newOutputStream(finalFilePath, StandardOpenOption.CREATE)) {
            for (int i = 0; i < totalChunks; i++) {
                Path chunkPath = Paths.get(UPLOAD_DIR, fileName + ".part" + i);
                Files.copy(chunkPath, finalOutputStream);
                Files.delete(chunkPath); // Удаляем временный chunk
            }
        }
    }

}
