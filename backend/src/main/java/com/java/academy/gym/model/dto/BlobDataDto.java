package com.java.academy.gym.model.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * Blob data dto
 */
public final class BlobDataDto implements Serializable {

    private static final long serialVersionUID = 3941028518346557027L;

    private final Long id;
    private final String name;
    private final Long size;
    private final String contentType;
    private final String url;

    public BlobDataDto(Long id, String name, Long size, String contentType, String url) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.contentType = contentType;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getSize() {
        return size;
    }

    public String getContentType() {
        return contentType;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlobDataDto)) return false;
        BlobDataDto that = (BlobDataDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(size, that.size) &&
                Objects.equals(contentType, that.contentType) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, size, contentType, url);
    }
}
