package com.bob.readbpmnfile.Read_File_BPMNFile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/bpmn")
public class ControllerBPMNFile {

    @Value("${file.upload-dir}")
    private String uploadDir;

    // Request to upload a file
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please upload a file.");
        }

        try {
            String cleanFileName = StringUtils.cleanPath(file.getOriginalFilename());
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(cleanFileName);
            Files.write(filePath, file.getBytes());

            return ResponseEntity.ok("File uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload file: " + e.getMessage());
        }
    }

    // Request to read a file from the static directory
    @GetMapping("/file/{fileName}")
    public ResponseEntity<String> getFileContent(@PathVariable String fileName) {
        try {
            Resource resource = new ClassPathResource("static/" + fileName);
            Path filePath = Paths.get(resource.getURI());

            if (Files.exists(filePath)) {
                String content = new String(Files.readAllBytes(filePath));
                return ResponseEntity.ok(content);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to read file: " + e.getMessage());
        }
    }
}