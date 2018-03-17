package com.java.academy.gym.service.impl;

import com.java.academy.gym.model.BlobData;
import com.java.academy.gym.model.dto.BlobDataDto;
import com.java.academy.gym.repository.BlobDataRepository;
import com.java.academy.gym.service.BlobDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of {@link BlobDataService}
 */
@Service
public class BlobDataServiceImpl implements BlobDataService {

    private static final Logger LOG = LoggerFactory.getLogger(BlobDataServiceImpl.class);

    private final BlobDataRepository blobDataRepository;

    public BlobDataServiceImpl(BlobDataRepository blobDataRepository) {
        this.blobDataRepository = blobDataRepository;
    }

    @Override
    @Transactional
    public List<BlobDataDto> save(List<MultipartFile> files) {
        if (files == null || files.size() == 0) {
            return Collections.emptyList();
        }

        return blobDataRepository.save(files.stream().map(f -> {
            BlobData blobData = new BlobData();
            blobData.setName(f.getOriginalFilename() != null ? f.getOriginalFilename() : f.getName());
            blobData.setSize(f.getSize());
            blobData.setContentType(f.getContentType());
            try {
                blobData.setObject(f.getBytes());
            } catch (IOException e) {
                LOG.error("Error saving file with name " + f.getOriginalFilename(), e);
            }
            return blobData;
        }).collect(Collectors.toList())).stream().map(b ->
                new BlobDataDto(b.getId(),
                        b.getName(),
                        b.getSize(),
                        b.getContentType(),
                        URL + b.getId()
                )
        ).collect(Collectors.toList());
    }

    @Override
    public Optional<BlobData> findBlobDataById(Long fileId) {
        return Optional.ofNullable(blobDataRepository.findOne(fileId));
    }
}
