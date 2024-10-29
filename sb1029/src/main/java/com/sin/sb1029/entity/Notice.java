package com.sin.sb1029.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name="notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer boardIdx;

    private String title;

    private String contents;

    @ColumnDefault("0") //default 0
    private Integer hitCnt;

    private String creatorId;

    private String createdDatetime;

    private String updaterId;

    private String updatedDatetime;

    @Column(columnDefinition = "varchar(2) default 'N'")
    private String deletedYn;
}
