//package com.example.SB_Week9.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http
////                .authorizeHttpRequests(auth -> auth
////                        .requestMatchers("/api/users/register", "/api/user/login", "/public-endpoints/**").permitAll() // Cho phép truy cập các endpoint công khai
////                        .anyRequest().authenticated() // Yêu cầu xác thực cho các endpoint khác
////                );
//////                .formLogin(form -> form
//////                        .loginPage("/login") // Đường dẫn đến trang đăng nhập
//////                        .permitAll()
//////                )
//////                .logout(logout -> logout.permitAll()
//////                );
////        return http.build();
////    }
//}
