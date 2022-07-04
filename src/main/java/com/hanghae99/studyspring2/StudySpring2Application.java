package com.hanghae99.studyspring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StudySpring2Application {

    public static void main(String[] args) {
        SpringApplication.run(StudySpring2Application.class, args);
    }

}
