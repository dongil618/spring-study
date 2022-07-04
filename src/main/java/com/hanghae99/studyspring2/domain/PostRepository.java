package com.hanghae99.studyspring2.domain;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOrderByModifiedAtDesc();     // JPA 공식문서를 보고 규칙에 맞게 작성한다면 JPA가 알아서 SQL문 짜줌 => 최신순 정렬
}
