package com.Bob_r.controller;


import com.Bob_r.dto.OrderDTO;
import com.Bob_r.enums.PaymentMethod;
import com.Bob_r.model.ResponseWrapper;
import com.Bob_r.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllOrders(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Orders are successfully retrieved",orderService.getOrderList(),HttpStatus.ACCEPTED));
    }

    @PutMapping()
    public ResponseEntity<ResponseWrapper> updateOrder (@RequestBody OrderDTO orderDTO){
        orderService.updateOrder(orderDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Order is updated",orderDTO,HttpStatus.CREATED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder (@RequestBody OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Oder is created",orderDTO,HttpStatus.CREATED));
    }

    @GetMapping("paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> getDiscountByPaymentMethod(@PathVariable("paymentMethod") PaymentMethod paymentMethod){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Orders are successfully retrieved",orderService.getOrderListByPaymentMethod(paymentMethod),HttpStatus.OK));
    }

    @GetMapping("email/{email}")
    public ResponseEntity<ResponseWrapper> getDiscountByPaymentMethod(@PathVariable("email") String email){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseWrapper("Orders are successfully retrieved",orderService.getOrderListByEmail(email),HttpStatus.OK));
    }
}
