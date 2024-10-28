package com.sin.sb1024.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Log4j2
public class SecurityConfig {

//    @Autowired
//    private UserDetailsService userDetailsService;

    @Bean
    PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("----------------filterChain------------------");
        http.authorizeHttpRequests()
//                .antMatchers("/**").denyAll()
//                .antMatchers("h2-console/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/sample/all").permitAll()
                .antMatchers("/sample/member").permitAll()
                .antMatchers("/sample/admin").hasRole("ADMIN")
                .antMatchers("/sample/register").permitAll()
                .antMatchers("/board/**").permitAll()
                .antMatchers("/mapper/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/sample/step3").permitAll()
                .antMatchers("/sample/agree").permitAll()
                .antMatchers("/message/**").permitAll()
                .anyRequest().authenticated();
        http.formLogin().loginPage("/sample/login").permitAll()
                .and()
                .logout()
                .logoutUrl("/sample/logout")  // 로그아웃 URL
                .logoutSuccessUrl("/sample/login") // 로그아웃 성공 후 리다이렉트할 URL
                .invalidateHttpSession(true) // 세션 무효화
                .deleteCookies("JSESSIONID") // JSESSIONID 쿠키 삭제
                .permitAll();
        http.csrf().disable();
        http.exceptionHandling().accessDeniedPage("/sample/accessDenied");
        http.csrf()
                .ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().sameOrigin();
        return http.build();
    }
}