package com.java.academy.gym.model;

import javax.persistence.*;

/**
 * Keep blob data like images, audios, videos etc.
 */
@Entity
@Table(name = "BLOB_DATA")
public class BlobData extends BaseEntity {

    private static final long serialVersionUID = -1428362344021023872L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SIZE")
    private Long size;

    @Column(name = "CONTENT_TYPE", nullable = false)
    private String contentType;

    @Lob
    @Column(name = "OBJECT", nullable = false)
    private byte[] object;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getObject() {
        return object;
    }

    public void setObject(byte[] object) {
        this.object = object;
    }
}
