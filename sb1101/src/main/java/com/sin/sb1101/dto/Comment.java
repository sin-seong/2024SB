package com.sin.sb1101.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)  // 여러 댓글 중 하나는 특정 Fnotice에 속한다.
    @JoinColumn(name = "fnotice_id")   // 이 컬럼이 외래키 역할을 한다.
    private Fnotice fnotice;

    private String username;
    private String content;
    private LocalDateTime createdAt;
}
