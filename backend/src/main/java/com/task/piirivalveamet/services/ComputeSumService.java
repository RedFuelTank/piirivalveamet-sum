package com.task.piirivalveamet.services;

import com.task.piirivalveamet.repositories.SumModel;
import com.task.piirivalveamet.repositories.SumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComputeSumService {
  private final SumRepository repository;
  public SumModel computeSumAndSave(int firstAddend, int secondAddend) {
    return repository.save(SumModel.sumOf(firstAddend, secondAddend));
  }
}
