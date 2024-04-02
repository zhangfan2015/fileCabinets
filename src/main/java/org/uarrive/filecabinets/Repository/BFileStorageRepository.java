package org.uarrive.filecabinets.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.uarrive.filecabinets.Entity.BFileStorage;

import java.util.List;
import java.util.Optional;

public interface BFileStorageRepository extends CrudRepository<BFileStorage, String> {
    @Override
    Optional<BFileStorage> findById(String s);

    @Query("select b from BFileStorage b where b.fileDirectory = ?1")
    List<BFileStorage> findByFileDirectory(String fileDirectory);

    List<BFileStorage> findByExpireDateGreaterThan(Long expireDate);
}