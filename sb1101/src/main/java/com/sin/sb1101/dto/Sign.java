package com.sin.sb1101.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class SignDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message= "사용자 이름은 필숩니다.")
    @Size(min = 3, max = 15, message= "사용자 이름은 최소 3자,최대 15자여야합니다")
    private String username;

    @NotBlank(message = "이메일 주소는 필수입니다.")
    @Email(message="유요한 이메일 주소를 입력하세요.")
    private String email;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Size(min = 8, max=20, message = "비밀번호는 최소 8자, 최대 20자이여야합니다.")
    private String password;

    @NotBlank(message = "비밀번호 확인은 필수입니다.")
    private String confirmPassword;

    private String department;

    public boolean isPasswordMatching(){
        return password !=null && password.equals(confirmPassword);
    }
}
