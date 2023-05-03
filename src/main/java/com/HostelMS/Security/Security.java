package com.HostelMS.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class Security {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails hostelAdmin=User
                .withUsername("Admin123")
                .password(passwordEncoder().encode("Admin123"))
                .roles("ADMIN")
                .build();
        UserDetails hostelUser=User
                .withUsername("User123")
                .password(passwordEncoder().encode("User123"))
                .roles("NORMAL")
                .build();
        InMemoryUserDetailsManager inMemoryUserDetailsManager=new InMemoryUserDetailsManager(hostelAdmin,hostelUser);
        return inMemoryUserDetailsManager;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/hms/api")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();

    }

}
