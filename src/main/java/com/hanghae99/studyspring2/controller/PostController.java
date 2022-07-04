package com.hanghae99.studyspring2.controller;

import com.hanghae99.studyspring2.domain.Post;
import com.hanghae99.studyspring2.domain.PostRepository;
import com.hanghae99.studyspring2.domain.PostRequestDto;
import com.hanghae99.studyspring2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/posts")
    public Post savePost(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/posts")
    public List<Post> getPostList(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/posts/{id}")
    public Long deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;
    }
}
