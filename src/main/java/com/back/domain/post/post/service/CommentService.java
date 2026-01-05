package com.back.domain.post.post.service;

import com.back.domain.post.post.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
