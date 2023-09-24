package com.example.jpaconcurrency.postlike;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostLikeController {

  private final PostLikeService postLikeService;

  @PutMapping("/{postId}/like/{userId}")
  public ResponseEntity<Boolean> switchLike(
      @PathVariable Long postId,
      @PathVariable Long userId
  ) {
    Boolean likeStatusResponse = postLikeService.switchLike(postId, userId);
    return ResponseEntity.ok(likeStatusResponse);
  }

}
