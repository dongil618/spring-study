package com.hanghae99.studyspring2.service;

import com.hanghae99.studyspring2.domain.Post;
import com.hanghae99.studyspring2.domain.PostRepository;
import com.hanghae99.studyspring2.domain.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("존재하지 않는 아이디입니다.")
        );
        post.update(requestDto);
        return post.getId();
    }
}
