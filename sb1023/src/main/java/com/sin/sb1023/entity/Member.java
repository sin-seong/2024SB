package com.sin.sb1023.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "team")

public class Member {

    @Id
    @Column(name="member_id")
    private String id;

    private String username;

    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }
//    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}
