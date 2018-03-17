package com.java.academy.gym.service;

import com.java.academy.gym.model.BlobData;
import com.java.academy.gym.model.dto.BlobDataDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

/**
 * Blob data service.
 */
public interface BlobDataService {
    String URL = "/blob/read/";

    List<BlobDataDto> save(List<MultipartFile> files);

    Optional<BlobData> findBlobDataById(Long fileId);
}
