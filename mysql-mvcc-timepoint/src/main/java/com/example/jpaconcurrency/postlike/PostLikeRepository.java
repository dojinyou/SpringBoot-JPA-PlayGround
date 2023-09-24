package com.example.jpaconcurrency.postlike;

import com.example.jpaconcurrency.user.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

  Optional<PostLike> findByUserAndPostId(User user, Long postId);
}
