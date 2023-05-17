package com.Bob_R.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        List<UserDetails> userList = new ArrayList<>();

        userList.add(new User("Mike", encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
        return new InMemoryUserDetailsManager(userList);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()// checking for role
                .antMatchers("/user/**").hasRole("ADMIN") // from controller user  bring condition which role responsible to see that pages
                .antMatchers("/project/**").hasRole("MANAGER") //from controller project => Manager can access to that pages
                .antMatchers("/task/employee/**").hasRole("EMPLOYEE")//from controller employee =>  Employee can access to that pages
                .antMatchers("/task/**").hasRole("MANAGER") //from controller task => Manager can access to that pages

                .antMatchers( // any matches from http
                        "/",
                "/login",
                "/fragments/**",
                "/assets/**",
                "/images/**"
                ).permitAll()// bring permission for user
                .anyRequest() // any other have request
                .authenticated() // to be authorized to be use that page or app
                .and() // and
                .httpBasic() // popup page Box
                .and()//and
                .build(); // build

    }
}
