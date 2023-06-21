package com.task.piirivalveamet.repositories;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public class SumModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private final int firstAddend;
  private final int secondAddend;
  private int sum;

  private SumModel(int firstAddend, int secondAddend) {
    this.firstAddend = firstAddend;
    this.secondAddend = secondAddend;
    this.sum = firstAddend + secondAddend;
  }

  public static SumModel sumOf(int firstAddend, int secondAddend) {
    return new SumModel(firstAddend, secondAddend);
  }
}
