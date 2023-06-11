package com.Bob_r.service;

import com.Bob_r.dto.OrderDTO;
import com.Bob_r.dto.UpdateOrderDTO;
import com.Bob_r.enums.PaymentMethod;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getOrderList();

    OrderDTO updateOrder(OrderDTO orderDTO);

    OrderDTO createOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod paymentMethod);

    List<OrderDTO> getOrderListByEmail(String email);
    OrderDTO updateOrderById(Long id, UpdateOrderDTO updateOrderDTO);
}
