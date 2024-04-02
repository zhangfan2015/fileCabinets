package org.uarrive.filecabinets.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.uarrive.filecabinets.Entity.BDemoEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<BDemoEntity, Long> {
    List<BDemoEntity> findById(int id);

    Page<BDemoEntity> findAllByNameContaining(String name, Pageable pageable);

    @Query("from b_demo where id < :id or name like :name")
    List<BDemoEntity> testPerson(@Param("id") Integer id, @Param("name")String name);
}