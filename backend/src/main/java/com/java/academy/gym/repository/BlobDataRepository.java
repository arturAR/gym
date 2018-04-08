package com.java.academy.gym.repository;

import com.java.academy.gym.model.BlobData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * JPA Repository {@link BlobData}
 */
public interface BlobDataRepository extends JpaRepository<BlobData, Long> {

    @Query("SELECT b.id, b.name, b.size, b.contentType, b.version " +
            " FROM BlobData b WHERE b.id=:id")
    Object[][] findOneWithoutBlob(@Param("id") Long id);
}
