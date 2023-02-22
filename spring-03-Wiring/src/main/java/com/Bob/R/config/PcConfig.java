package com.Bob.R.config;

import com.Bob.R.casefactory.Case;
import com.Bob.R.casefactory.DellCase;
import com.Bob.R.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {

    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50,10,10);
    }


    @Bean
    public Case caseDell(Dimensions dimensions){
        return new DellCase("220B","Dell","240",dimensions);
    }
}
