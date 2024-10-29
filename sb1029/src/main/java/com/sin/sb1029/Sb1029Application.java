package com.sin.sb1029;

import com.sin.sb1029.entity.Notice;
import com.sin.sb1029.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class Sb1029Application {

        @Autowired
        private NoticeRepository noticeRepository;
    public static void main(String[] args) {
        SpringApplication.run(Sb1029Application.class, args);
    }
    @PostConstruct
    public void init() {

        IntStream.rangeClosed(1,100).forEach(i -> {//1부터100까지
            Notice notice = Notice.builder()
                    .title("제목"+i)
                    .createdDatetime(LocalDateTime.now().toString().substring(0,10))
                    .contents("내용"+i)
                    .deletedYn("N")
                    .hitCnt(0)
                    .build();
            noticeRepository.save(notice);
        });
}}
