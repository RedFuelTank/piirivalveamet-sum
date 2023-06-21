package com.task.piirivalveamet.services;

import com.task.piirivalveamet.repositories.SumModel;
import com.task.piirivalveamet.repositories.SumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchSumService {
  private final SumRepository repository;
  public Page<SumModel> searchSum(int number, Pageable pageable) {
    return repository.findAllByAddendsOrSum(number, pageable);
  }

  public Page<SumModel> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

}
