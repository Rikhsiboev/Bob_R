package com.pizza.controller;

import com.pizza.Enum.QuantityEnum;
import com.pizza.dto.adress.Address;
import com.pizza.dto.chesse.Cheese;
import com.pizza.service.serviceImp.serviceImp.CheeseImp;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class controller {
    private CheeseImp cheeseImp;

    public controller(CheeseImp cheeseImp) {
        this.cheeseImp = cheeseImp;
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }



    @GetMapping("/homeAction")
    public String home1(Model model) {
       model.addAttribute("cheese", cheeseImp) ;
        return "design";
    }

    @PostMapping ("/homeAction")
    public String home2() {

        return "design";
    }
    @GetMapping("/orderAction")
    public String home3(Model model) {
        model.addAttribute("address", new Address());
        model.addAttribute("cheese", cheeseImp) ;
        return "OrderAction";
    }

    @PostMapping("/create-pizza")
    public String home4(){
        return "redirect:/ThankYouDone";
    }
    @GetMapping("/ThankYouDone")
    public String home5(){
        return "/ThankYouPage";
    }
}
