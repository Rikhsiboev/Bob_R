package com.Bob_r.service.serviceIMP;

import com.Bob_r.dto.OrderDTO;
import com.Bob_r.entity.Order;
import com.Bob_r.enums.PaymentMethod;
import com.Bob_r.mapper.MapperUtil;
import com.Bob_r.repository.OrderRepository;
import com.Bob_r.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final MapperUtil mapperUtil;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
    }

    public List<OrderDTO> getOrderList(){

        return orderRepository.findAll().stream()
                .map(obj -> mapperUtil.convert(obj, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {
        Long orderId = orderDTO.getId();

        Order order= mapperUtil.convert(orderDTO, new Order());

        orderRepository.findById(orderId).ifPresent(dbOrder -> {
            dbOrder.setCart(order.getCart());
            dbOrder.setPaidPrice(order.getPaidPrice());
            dbOrder.setTotalPrice(order.getTotalPrice());
            dbOrder.setCustomer(order.getCustomer());
            dbOrder.setPayment(order.getPayment());

            orderRepository.save(dbOrder);
        });
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        orderRepository.save(mapperUtil.convert(orderDTO, new Order()));
        return orderDTO;
    }

    @Override
    public List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod paymentMethod) {
        return orderRepository.findAllByPayment_PaymentMethod(paymentMethod)
                .stream().map(obj -> mapperUtil.convert(obj, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderListByEmail(String email) {
        return orderRepository.findAllByCustomer_Email(email)
                .stream().map(obj -> mapperUtil.convert(obj, new OrderDTO()))
                .collect(Collectors.toList());
    }
}