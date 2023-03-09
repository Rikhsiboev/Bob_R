package com.Bob_R.controller;

import com.Bob_R.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class studentController {
    @RequestMapping("/welcome")
    public String homePage(Model model) {
        // model interface
        model.addAttribute("name","Course");
        model.addAttribute("course","Abc");
        String subject = "Spring Boot";
        model.addAttribute("subject",subject);
        int studentId = new Random().nextInt();
        model.addAttribute("id",studentId);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        model.addAttribute("numbers",numbers);
        LocalDate dt = LocalDate.now();
        model.addAttribute("date",dt);

        Student student = new Student(UUID.randomUUID(),"Mike","Smith");
        model.addAttribute("student",student);

        return "/student/welcome";
    }
}
