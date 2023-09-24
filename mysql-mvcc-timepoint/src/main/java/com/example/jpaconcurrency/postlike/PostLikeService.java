package com.example.jpaconcurrency.postlike;

import com.example.jpaconcurrency.post.Post;
import com.example.jpaconcurrency.post.PostRepository;
import com.example.jpaconcurrency.user.User;
import com.example.jpaconcurrency.user.UserRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostLikeService {

  private final PostLikeRepository postLikeRepository;
  private final UserRepository userRepository;
  private final PostRepository postRepository;

  @Transactional
  public Boolean switchLike(Long postId, Long userId) {
    try {
      User user = userRepository.findById(userId).orElseThrow(); // 사용자 조회
      Post post = postRepository.findById(postId).orElseThrow(); // 좋아요 누를 게시물

      Optional<PostLike> postLike = postLikeRepository.findByUserAndPostId(user, postId); // 사용자가 이미 좋아요를 눌렀는지 확인

      switchLike(postLike, post, user);
      return postLike.isEmpty();
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return null;
    }
  }

  private void switchLike(Optional<PostLike> postLike, Post post, User user) {
    if (postLike.isPresent()) {  // 좋아요를 눌렀는지 확인
      postLikeRepository.delete(postLike.get()); // 이미 좋아요가 있으면 삭제
      post.decreaseLikeCount(); // Post의 Like 감소
      return;
    }

    postLikeRepository.save(new PostLike(user, post)); // 좋아요를 누르지 않았으면 좋아요 테이블에 레코드 추가
    post.increaseLikeCount(); // Post의 Like 컬럼 상승
  }

}
