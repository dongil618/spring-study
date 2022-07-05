package com.hanghae99.studyspring2.controller;

import com.hanghae99.studyspring2.domain.Post;
import com.hanghae99.studyspring2.domain.PostRepository;
import com.hanghae99.studyspring2.domain.PostRequestDto;
import com.hanghae99.studyspring2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;

    @PostMapping("/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    @GetMapping("/posts")
    public List<Post> getPostList(){
//        List<Post> result = postRepository.findAllByOrderByModifiedAtDesc();
//        System.out.println(result.toString());
//        for(int i = 0; i < result.size(); i ++){
//            System.out.println("id : " + result.get(i).getId());
//            System.out.println("username : " + result.get(i).getUsername());
//            System.out.println("title : " + result.get(i).getTitle());
//        }
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    @DeleteMapping("/posts/{id}")
    public Long deletePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            System.out.println("post.get().getPassword() : " + post.get().getPassword() + " requestDto.getPassword() : " + requestDto.getPassword());
            if (post.get().getPassword().equals(requestDto.getPassword())) {
                postRepository.deleteById(id);
            } else {
                System.out.println("비밀번호 오류");
                return 0L;
            }
        }
        return id;
    }

    @PutMapping("posts/{id}")
    public  Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            System.out.println("post.get().getPassword() : " + post.get().getPassword() + " requestDto.getPassword() : " + requestDto.getPassword());
            if (post.get().getPassword().equals(requestDto.getPassword())) {
                postService.update(id, requestDto);
            } else {
                System.out.println("비밀번호 오류");
                return 0L;
            }
        }
        return id;
    }
}
