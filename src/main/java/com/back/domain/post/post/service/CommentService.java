package com.back.domain.post.post.service;

import com.back.domain.post.post.document.Comment;
import com.back.domain.post.post.document.Post;
import com.back.domain.post.post.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : JAKE
 * @date : 26. 1. 5.
 */
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public long count() {
        return commentRepository.count();
    }

    public Comment findById(String id) {
        return commentRepository.findById(id).orElseThrow(() -> new RuntimeException("Comment not found with id: " + id));
    }

    public List<Comment> findByPostId(String postId) {
        return commentRepository.findByPostId(postId);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public Comment create(Post post, String content, String author) {
        Comment comment = new Comment(post.getId(), content, author);
        return commentRepository.save(comment);
    }
}
