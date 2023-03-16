package com.Bob_R.boostrap;

import com.Bob_R.dto.ProjectDTO;
import com.Bob_R.dto.RoleDTO;
import com.Bob_R.dto.UserDTO;
import com.Bob_R.enums.Gender;
import com.Bob_R.enums.Status;
import com.Bob_R.service.ProjectService;
import com.Bob_R.service.RoleService;
import com.Bob_R.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DataGenerator implements CommandLineRunner {

    //Dependency injection

    private final RoleService roleService;
    private final UserService userService;
    private final ProjectService projectService;

    public DataGenerator(RoleService roleService, UserService userService, ProjectService projectService) {
        this.roleService = roleService;
        this.userService = userService;
        this.projectService = projectService;
    }


    @Override
    public void run(String... args) throws Exception {

        //This run method will execute First BEFORE ANYTHING when you start the application
        //create some roles and put in the DB(map)
        //create users and put in  the  DB (map)

        RoleDTO adminRole = new RoleDTO(1L,"Admin");
        RoleDTO managerRole = new RoleDTO(2L,"Manager");
        RoleDTO employeeRole = new RoleDTO(3L,"Employee");
        roleService.save(adminRole);
        roleService.save(managerRole);
        roleService.save(employeeRole);


        // adding our object to DB but here we are using Map in AbstractMethod on service imp
//        RoleServiceImp rs = new RoleServiceImp();
//        rs.save(adminRole); // but we are using her Tight Coupling we have to use Loose coupling
//          ===>> Ioc  Inversion of control as dependency injection

        UserDTO user1 = new UserDTO("John", "Kesy",
                "john@shgfso.com", "Abc1", true, "7459684532", managerRole, Gender.MALE);
        UserDTO user5 = new UserDTO("Mike", "Smith",
                "mike@csgfh.com", "Abc2", true, "7459684532", adminRole, Gender.MALE);
        UserDTO user2 = new UserDTO("Delisa",
                "Norre", "delisa@cshgfo.com", "123", true, "8567412358", managerRole, Gender.FEMALE);
        UserDTO user3 = new UserDTO("Craig", "Jark",
                "craig@dghjk.com", "Abc3", true, "7777775566", employeeRole, Gender.MALE);
        UserDTO user4 = new UserDTO("Shaun",
                "Hayns", "shaun@cdhgcom", "Abc4", true, "3256987412", managerRole, Gender.MALE);
        UserDTO user6 = new UserDTO("Elizebeth",
                "Loren", "elizebeth@cadfg.com", "Abc4", true, "5306987412", employeeRole, Gender.FEMALE);
        UserDTO user7 = new UserDTO("Maria",
                "Ada", "maria@cgsdfghcom", "Abc4", true, "9996987412", employeeRole, Gender.FEMALE);
        UserDTO user8 = new UserDTO("Bill",
                "Matt", "bill@cghjeydo.com", "Abc4", true, "8881239846", employeeRole, Gender.MALE);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        userService.save(user6);
        userService.save(user7);
        userService.save(user8);


        ProjectDTO project1 = new ProjectDTO("Spring MVC", "PR001", user1, LocalDate.now(), LocalDate.now().plusDays(25), "Creating Controllers", Status.OPEN);
        ProjectDTO project2 = new ProjectDTO("Spring ORM", "PR002", user2, LocalDate.now(), LocalDate.now().plusDays(10), "Creating Database", Status.IN_PROGRESS);
        ProjectDTO project3 = new ProjectDTO("Spring Container", "PR003", user1, LocalDate.now(), LocalDate.now().plusDays(32), "Creating Container", Status.IN_PROGRESS);

        projectService.save(project1);
        projectService.save(project2);
        projectService.save(project3);

    }
}
