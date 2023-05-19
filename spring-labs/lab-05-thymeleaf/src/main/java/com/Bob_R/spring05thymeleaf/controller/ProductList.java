package com.Bob_R.spring05thymeleaf.controller;

import com.Bob_R.spring05thymeleaf.service.impl.ProductServiceImpl;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ProductList {
    private final ProductServiceImpl productService;

    public ProductList(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public String list (Model model){
        model.addAttribute("product",productService.listProduct());
        return "/product/list";
    }

    @GetMapping("/create")
    public String create_Form (Model model){

        return "/product/create-product";
    }
}
