package com.Bob_R.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomConfig {

    @Bean
    public String myString(){
        return "Bob_R";
    }

    @Bean
    public Integer myInteger(){
        return 5;
    }
}
