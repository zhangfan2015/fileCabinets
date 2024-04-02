package org.uarrive.filecabinets.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.uarrive.filecabinets.Entity.BDemoEntity;

public interface BDemoEntityRepository extends ListPagingAndSortingRepository<BDemoEntity, Integer> {
}