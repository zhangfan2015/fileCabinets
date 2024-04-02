package org.uarrive.filecabinets.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.uarrive.filecabinets.Entity.DSysSetting;

import java.util.Optional;

public interface DSysSettingRepository extends CrudRepository<DSysSetting, Integer> {


    @Query("select d from DSysSetting d where d.key = ?1")
    Optional<DSysSetting> findByKey(String key);

    @Override
    Optional<DSysSetting> findById(Integer integer);
}