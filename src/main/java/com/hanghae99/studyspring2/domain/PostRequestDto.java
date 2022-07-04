package com.hanghae99.studyspring2.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class PostRequestDto {

    private String username;
    private String contents;
}
