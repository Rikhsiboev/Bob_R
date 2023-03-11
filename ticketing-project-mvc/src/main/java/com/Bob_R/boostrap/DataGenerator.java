package com.Bob_R.boostrap;

import com.Bob_R.dto.RoleDTO;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        //This run method will execute First BEFORE ANYTHING when you start the application
        //create some roles and put in the DB(map)
        //create users and put in  the  DB (map)

        RoleDTO adminRole = new RoleDTO(1L,"admin");
        RoleDTO managerRole = new RoleDTO(2L,"Manager");
        RoleDTO employeeRole = new RoleDTO(3L,"Employee");



    }
}
