package com.task.piirivalveamet.controllers;

import com.task.piirivalveamet.repositories.SumModel;
import com.task.piirivalveamet.services.ComputeSumService;
import com.task.piirivalveamet.services.SearchSumService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
public class SumController {
  private final ComputeSumService computeService;
  private final SearchSumService searchService;

  @GetMapping("/sum")
  SumModel sum(@RequestParam @Min(0) @Max(100) Integer firstAddend,
               @RequestParam @Min(0) @Max(100) Integer secondAddend) {
    return computeService.computeSumAndSave(firstAddend, secondAddend);
  }

  @GetMapping("/search/{number}")
  Page<SumModel> searchBy(@PathVariable @Min(0) @Max(100) Integer number,
                          @SortDefault(sort = "sum", direction = Sort.Direction.DESC) Pageable pageable) {
    return searchService.searchSum(number, pageable);
  }

  @GetMapping("/search")
  Page<SumModel> findAll(@SortDefault(sort = "sum", direction = Sort.Direction.DESC) Pageable pageable) {
    return searchService.findAll(pageable);
  }
}
