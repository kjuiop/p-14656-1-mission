package com.back.domain.post.post.repository;

import com.back.domain.post.post.document.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author : JAKE
 * @date : 26. 1. 5.
 */
public interface CommentRepository extends ElasticsearchRepository<Comment, String> {
    List<Comment> findAll();

    List<Comment> findByPostId(String postId);
}
