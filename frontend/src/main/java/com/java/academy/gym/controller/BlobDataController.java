package com.java.academy.gym.controller;

import com.java.academy.gym.model.BlobData;
import com.java.academy.gym.service.BlobDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@RestController
@RequestMapping("/blob")
public class BlobDataController {

    private static final Logger LOG = LoggerFactory.getLogger(BlobDataController.class);

    private final BlobDataService blobDataService;

    public BlobDataController(BlobDataService blobDataService) {
        this.blobDataService = blobDataService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("files") List<MultipartFile> multipartFiles) {

        LOG.info("Start uploading of {} file(s)", multipartFiles.size());

        if (multipartFiles.isEmpty()) {
            return new ResponseEntity<>("Please select a file(s)!", HttpStatus.OK);
        }

        try {
            return ResponseEntity.ok(blobDataService.save(multipartFiles));
        } catch (Exception e) {
            LOG.error("Error uploading", e);
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Resource> readFile(@PathVariable("id") Long fileId) {
        Optional<BlobData> blobDataOptional = blobDataService.findBlobDataById(fileId);
        if (!blobDataOptional.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        ByteArrayResource resource = new ByteArrayResource(blobDataOptional.get().getObject());
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(blobDataOptional.get().getSize())
                .contentType(MediaType.parseMediaType(blobDataOptional.get().getContentType()))
                .body(resource);
    }
}
