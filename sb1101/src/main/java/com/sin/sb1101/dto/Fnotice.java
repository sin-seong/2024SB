package com.sin.sb1101.dto;


import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Fnotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Lob
    private String content;
    private String username;


    private LocalDateTime date;
    private int hitCnt;


}
