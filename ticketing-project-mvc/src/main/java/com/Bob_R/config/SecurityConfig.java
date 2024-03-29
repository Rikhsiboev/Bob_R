package com.Bob_R.config;

import com.Bob_R.service.SecurityServiceInterface;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration

public class SecurityConfig {


    private final SecurityServiceInterface securityServiceInterface;
    private final AuthSuccessHandler authSuccessHandler;

    public SecurityConfig(SecurityServiceInterface securityServiceInterface, AuthSuccessHandler authSuccessHandler) {
        this.securityServiceInterface = securityServiceInterface;
        this.authSuccessHandler = authSuccessHandler;
    }


    /// this is hard code we are changing that soft code from our data Base
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        List<UserDetails> userList = new ArrayList<>();
//
//        userList.add(new User("Mike", encoder.encode("password"), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
//        userList.add(new User("Bob", encoder.encode("password1"), Arrays.asList(new SimpleGrantedAuthority("ROLE_MANAGER®"))));
//        return new InMemoryUserDetailsManager(userList);
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests()// checking for role
//                .antMatchers("/user/**").hasRole("ADMIN") // from controller user  bring condition which role responsible to see that pages
//                .antMatchers("/project/**").hasRole("MANAGER") //from controller project => Manager can access to that pages
//                .antMatchers("/task/employee/**").hasRole("EMPLOYEE")//from controller employee =>  Employee can access to that pages
//                .antMatchers("/task/**").hasRole("MANAGER") //from controller task => Manager can access to that pages
                .antMatchers("/user/**").hasAuthority("Admin") // For DB
                .antMatchers("/project/**").hasAuthority("Manager")
                .antMatchers("/task/employee/**").hasAuthority("Employee")
                .antMatchers("/task/**").hasAuthority("Manager")
                //        .antMatchers("/task/**").hasAnyRole("EMPLOYEE","ADMIN")  // more than one role
//                .antMatchers("/task/**").hasAuthority("ROLE_EMPLOYEE")

                .antMatchers( // any matches from http
                        "/",
                        "/login",
                        "/fragments/**",
                        "/assets/**",
                        "/images/**"
                )
                .permitAll()// bring permission for user
                .anyRequest() // any other have request
                .authenticated() // to be authorized to be use that page or app
                .and() // and
//                .httpBasic() // popup page Box
//                .and()//and
////                .build(); // build
                .formLogin()  // form login for controlling Thymeleaf pages in our app
                .loginPage("/login")
//                .defaultSuccessUrl("/welcome")  // after login welcome page condition

                //modify which page after login system from role
                .successHandler(authSuccessHandler)

                .failureUrl(         "/login?error=true ")//error
                .permitAll()//accuse to everyone
                .and()
                // Logout
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                //Remember me
                .rememberMe()
                    .tokenValiditySeconds(120) // how many secound
                    .key("Bob")                 // ad key behind
                    .userDetailsService(securityServiceInterface) // injection security Remember me who?
                .and()
                .build();

    }
}
