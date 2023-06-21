package com.task.piirivalveamet.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SumRepository extends CrudRepository<SumModel, Long> {
  @Query("SELECT m FROM SumModel m WHERE m.firstAddend = :number OR m.secondAddend = :number OR m.sum = :number")
  Page<SumModel> findAllByAddendsOrSum(int number, Pageable pageable);

  Page<SumModel> findAll(Pageable pageable);
}
