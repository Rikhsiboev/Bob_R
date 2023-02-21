package com.cydeo.Bob_R.config;

import com.cydeo.Bob_R.casefactory.Case;
import com.cydeo.Bob_R.casefactory.DellCase;
import com.cydeo.Bob_R.monitorfactory.AcerMonitor;
import com.cydeo.Bob_R.monitorfactory.Monitor;
import com.cydeo.Bob_R.monitorfactory.SonyMonitor;
import com.cydeo.Bob_R.motherboardfactory.AsusMotherboard;
import com.cydeo.Bob_R.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ComputerConfig {

    @Bean(name="sony")
    public Monitor monitorSony(){

        return new SonyMonitor("25 inch Beast","Sony",25);
    }

    @Bean(name="sony2")
    public Monitor monitorSony2(){

        return new SonyMonitor("40 inch Beast","Sony",40);
    }


    @Bean
    @Primary
    public Monitor monitorAcer(){
        return new AcerMonitor("23 inch Beast","Acer",23);
    }


    @Bean
    public Case caseDell(){
        return new DellCase("220B","Dell","240");
    }

    @Bean
    public Motherboard motherboardAsus(){
        return new AsusMotherboard("BJ-200","Asus",4,6,"v2.44");
    }




}
