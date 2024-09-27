package com.farmstory.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

//    private final CustomAuthenticationSuccessHandler successHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(auth->auth.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**","/error","/file/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/view/login")  // 로그인 페이지 URL
                        .loginProcessingUrl("/auth/user/login")  // 로그인 인증 처리 URL (디비 처리)
                        .defaultSuccessUrl("/")  // 로그인 성공 후 이동할 URL
                        .failureUrl("/view/login?error=true")  // 로그인 실패 시 이동할 URL
                        .usernameParameter("userName")  // 사용자명 파라미터 이름
                        .passwordParameter("pwd")  // 비밀번호 파라미터 이름
                        .permitAll()  // 로그인 페이지는 인증 없이 접근 가능
                )
                .logout(logout -> logout
                        .invalidateHttpSession(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/auth/user/logout"))
                        .logoutSuccessUrl("/view/login"))
                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                )
        ;
        return http.build();

//        http
//                .csrf(auth -> auth.disable()) // CSRF 비활성화
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/admin/**").hasRole("ADMIN") // 관리자만 접근 가능
//                        .requestMatchers("/client/**").hasRole("USER") // 일반 사용자만 접근 가능
//                        .requestMatchers("/mypage/**").authenticated() // 인증된 사용자만 접근 가능
//                        .requestMatchers("/**").permitAll() // 그 외 모든 요청은 모두 허용
//                        .anyRequest().authenticated() // 그 외 모든 요청은 인증 필요
//                )
//                .httpBasic(Customizer.withDefaults()) // 기본 HTTP 인증 방식 사용
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션을 상태없이 유지
//                );
//                이후에 실제로 써야하는 보안 설정
//                admin에 관한 접속 권한은 admin 역할 을 가진 사용자만
    }

    @Bean
    public PasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }


}
