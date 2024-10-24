//package com.example.SB_Week9.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()  // Tắt CSRF (Cross-Site Request Forgery) cho API
//                .authorizeRequests()
//                .antMatchers("/api/users/register").permitAll()  // Cho phép tất cả truy cập API đăng ký
//                .antMatchers("/api/users/**").hasRole("ADMIN")  // Chỉ admin có quyền truy cập các API khác
//                .anyRequest().authenticated()  // Các request khác cần phải xác thực
//                .and()
//                .httpBasic();  // Sử dụng xác thực HTTP Basic (có thể thay bằng JWT)
//
//        return http.build();
//    }
//
//    // Bean PasswordEncoder để mã hóa mật khẩu
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Bean UserDetailsService để nạp thông tin người dùng từ cơ sở dữ liệu
//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepository) {
//        return new CustomUserDetailsService(userRepository);
//    }
//}
