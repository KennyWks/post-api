package post.example.post.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import post.example.post.service.impl.AppUserDetailService;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class AppSecurityConfiguration {

    private AppUserDetailService appUserDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors().disable()
                .csrf().disable()
                .authorizeRequests(auth ->
                        auth
                                .antMatchers(HttpMethod.POST, "/user").permitAll()// Registration
                                .anyRequest().authenticated())
                .userDetailsService(appUserDetailService)
                .httpBasic()
                .and()
                .build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
