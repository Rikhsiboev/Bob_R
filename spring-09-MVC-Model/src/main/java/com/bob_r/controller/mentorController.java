package com.Bob_R.controller;

import com.Bob_R.mentor.Gender;
import com.Bob_R.mentor.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mentorController {
    @RequestMapping("/mentor")
    public String homePage(Model model){

        String fistName = "Fist Name";
        String lastName = "Last Name";
        String age = "Age";
        String gender = "Gender";

        model.addAttribute("fistName",fistName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("age",age);
        model.addAttribute("gender",gender);





        Mentor mentor1 = new Mentor("MIKE","Smith",45, Gender.MALE);
        Mentor mentor2 = new Mentor("TOM","Hanks",65, Gender.MALE);
        Mentor mentor3 = new Mentor("AMMY","Bryan",25, Gender.FEMALE);
        model.addAttribute("mentor1",mentor1);
        model.addAttribute("mentor2",mentor2);
        model.addAttribute("mentor3",mentor3);
        return "/mentor/mentor";
    }


}
