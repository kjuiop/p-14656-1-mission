package com.back.domain.post.post.repository;

import com.back.domain.post.post.document.Post;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author : JAKE
 * @date : 26. 1. 5.
 */
public interface PostRepository extends ElasticsearchRepository<Post, String> {
}
