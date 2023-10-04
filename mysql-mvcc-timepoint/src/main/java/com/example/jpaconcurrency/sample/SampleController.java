package com.example.jpaconcurrency.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/sample")
public class SampleController {

  private final SampleRepository sampleRepository;

  @PostMapping
  public String create() {
    return sampleRepository.save(new Sample()).getId();
  }

}
