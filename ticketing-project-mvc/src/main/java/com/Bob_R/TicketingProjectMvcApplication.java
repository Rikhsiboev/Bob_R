package com.Bob_R;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketingProjectMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketingProjectMvcApplication.class, args);

    }
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper() ;
    }
}
