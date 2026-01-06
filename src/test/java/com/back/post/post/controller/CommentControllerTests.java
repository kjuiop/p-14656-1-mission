package com.back.post.post.controller;

import com.back.BaseTest;
import com.back.domain.post.post.document.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : JAKE
 * @date : 26. 1. 6.
 */
@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
public class CommentControllerTests extends BaseTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private Post createTestPost() throws Exception {
        String response = mockMvc.perform(
                post("/api/v1/posts")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(
                                new Post("Test Post Title", "Test Post Content", "Test Post Author")
                        ))
        ).andExpect(status().isCreated())
         .andReturn()
         .getResponse()
         .getContentAsString();

        return objectMapper.readValue(response, Post.class);
    }

    @Test
    @DisplayName("POST /api/v1/posts/{postId}/comments - 실패 (content 누락)")
    void t1() throws Exception {
        Post post = createTestPost();
        mockMvc.perform(
                post("/api/v1/posts/{postId}/comments", post.getId())
                        .contentType("application/json")
                        .content(
                                objectMapper.writeValueAsBytes(
                                        Map.of(
                                                "author", "Test Author"
                                        )
                                )
                        )
        ).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("POST /api/v1/posts/{postId}/comments - 실패 (존재하지 않는 postId)")
    void t2() throws Exception {
        mockMvc.perform(
                post("/api/v1/posts/{postId}/comments", "nonexistent-post-id")
                        .contentType("application/json")
                        .content(
                                objectMapper.writeValueAsBytes(
                                        Map.of(
                                                "content", "Test Content",
                                                "author", "Test Author"
                                        )
                                )
                        )
        ).andExpect(status().isNotFound());
    }
}
