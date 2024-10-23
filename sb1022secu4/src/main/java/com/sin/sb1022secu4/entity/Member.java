package com.sin.sb1022secu4.entity;

import com.sin.sb1022secu4.spring.WrongIdPasswordException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @Column(nullable = false)
    private String role;

    @Column
    private LocalDateTime regdate;

    public Member(String email, String username, String password, String role, LocalDateTime regdate) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.regdate = regdate;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!password.equals(oldPassword))
            throw new WrongIdPasswordException();
        this.password = newPassword;
    }
}
