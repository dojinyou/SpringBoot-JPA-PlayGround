package com.example.jpaconcurrency.post;

import jakarta.persistence.LockModeType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface PostRepository extends JpaRepository<Post, Long> {

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  Optional<Post> findById(Long id);

}
