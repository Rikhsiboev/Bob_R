package com.Bob_R.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("Bob_R")
@ComponentScan(basePackages = {"com.Bob_R.config","com.Bob_R.proxy","com.Bob_R.repository","com.Bob_R.service"})
public class CommentConfig {
}
