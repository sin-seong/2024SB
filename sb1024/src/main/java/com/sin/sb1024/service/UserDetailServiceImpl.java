package com.sin.sb1024.service;


import com.sin.sb1024.entity.Member;
import com.sin.sb1024.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class UserDetailServiceImpl implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    public UserDetailServiceImpl(PasswordEncoder passwordEncoder, MemberRepository memberRepository) {
        this.passwordEncoder = passwordEncoder;
        this.memberRepository = memberRepository;
    }

    @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                log.info("====================>사용자:"+ username);
//                UserDetails user = User.withUsername("user123")
//                .password(passwordEncoder().encode("1234"))
//                .roles("ADMIN")
//                .build();
//                return user;
//            Member member = Member.builder()
//                    .id(1001L)
//                    .username("홍길동")
//                    .password(passwordEncoder().encode("1234"))
//                    .email("hong@aaa.com")
//                    .build();
//                return  toUserDetails(member);
        Optional<Member> member = memberRepository.findByUsername(username);
        return toUserDetails(member.get());
    }

            private PasswordEncoder passwordEncoder() {  return new BCryptPasswordEncoder();  }

            private UserDetails toUserDetails(Member member){
                return User.builder()
                        .username(member.getUsername())
                        .password(member.getPassword())
//                        .authorities(new SimpleGrantedAuthority(member.getRole().toString()))
                        .roles(member.getRole())
                        .build();
            }
}
