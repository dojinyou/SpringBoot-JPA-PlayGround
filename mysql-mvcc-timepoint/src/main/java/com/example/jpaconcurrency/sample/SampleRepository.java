package com.example.jpaconcurrency.sample;

import org.springframework.data.jpa.repository.JpaRepository;

interface SampleRepository extends JpaRepository<Sample, String> {
}
