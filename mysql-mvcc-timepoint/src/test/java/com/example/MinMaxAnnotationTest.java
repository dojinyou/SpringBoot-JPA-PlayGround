package com.example;

import autoparams.AutoSource;
import autoparams.Repeat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;

public class MinMaxAnnotationTest {

  private static final long MIN_VALUE = 100;
  private static final long MAX_VALUE = 150;

  @ParameterizedTest
  @AutoSource
  @Repeat
  public void javaxValidationText(
      @javax.validation.constraints.Min(MIN_VALUE)
      @javax.validation.constraints.Max(MAX_VALUE)
      int value
  ) {
    Assertions.assertThat(value)
        .isGreaterThanOrEqualTo((int)MIN_VALUE)
        .isLessThanOrEqualTo((int)MAX_VALUE);
  }

  @ParameterizedTest
  @AutoSource
  @Repeat
  public void jakartaValidationText(
      @jakarta.validation.constraints.Min(MIN_VALUE)
      @jakarta.validation.constraints.Max(MAX_VALUE)
      int value
  ) {
    Assertions.assertThat(value)
        .isGreaterThanOrEqualTo((int)MIN_VALUE)
        .isLessThanOrEqualTo((int)MAX_VALUE);
  }
}
