package com.Bob_r.controller;

import com.Bob_r.dto.ProductDTO;
import com.Bob_r.dto.ProductRequest;
import com.Bob_r.model.ResponseWrapper;
import com.Bob_r.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<ResponseWrapper> getProductList() {
        return ResponseEntity.ok(new ResponseWrapper("Product are successfully retrieved",
                productService.retrieveProductList(),
                HttpStatus.ACCEPTED));
    }
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(
//                        new ResponseWrapper("Product are successfully retrieved",
//                                productService.retrieveProductList(),
//                                HttpStatus.ACCEPTED));


    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully update",
                productService.updateProduct(productDTO),HttpStatus.ACCEPTED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully created",
                productService.createProduct(productDTO),HttpStatus.ACCEPTED));
    }

    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> retrieveProductByCategoryAndPrice(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved.",
                productService.retrieveAllProductByCategoryAndPrice(productRequest.getCategoryList(),productRequest.getPrice()),HttpStatus.OK));
    }




}

