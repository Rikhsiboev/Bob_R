package com.Bob_r.service.serviceIMP;

import com.Bob_r.dto.OrderDTO;
import com.Bob_r.dto.UpdateOrderDTO;
import com.Bob_r.entity.Order;
import com.Bob_r.enums.PaymentMethod;
import com.Bob_r.exception.NotFoundException;
import com.Bob_r.mapper.MapperUtil;
import com.Bob_r.repository.OrderRepository;
import com.Bob_r.service.CartService;
import com.Bob_r.service.CustomerService;
import com.Bob_r.service.OrderService;
import com.Bob_r.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final CartService cartService;

    private final MapperUtil mapperUtil;

    public OrderServiceImpl(OrderRepository orderRepository,
                            CustomerService customerService,
                            PaymentService paymentService,
                            CartService cartService,
                            MapperUtil mapperUtil) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.paymentService = paymentService;
        this.cartService = cartService;
        this.mapperUtil = mapperUtil;
    }

    public List<OrderDTO> getOrderList(){

        return orderRepository.findAll().stream()
                .map(obj -> mapperUtil.convert(obj, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        // Look for the orderId inside the database and throw the exception
        orderRepository.findById(
                orderDTO.getId()).orElseThrow(
                        ()-> new RuntimeException("Order could not be found"));

        //then we need to check if the order fields are exist or not

        validateRelatedFieldsAreExist(orderDTO);

        Order willBeUpdatedOrder = mapperUtil.convert(orderDTO, new Order());
        Order updatedOrder = orderRepository.save(willBeUpdatedOrder);
        return mapperUtil.convert(updatedOrder,new OrderDTO());
   /*     Long orderId = orderDTO.getId();

        Order order= mapperUtil.convert(orderDTO, new Order());

        orderRepository.findById(orderId).ifPresent(dbOrder -> {
            dbOrder.setCart(order.getCart());
            dbOrder.setPaidPrice(order.getPaidPrice());
            dbOrder.setTotalPrice(order.getTotalPrice());
            dbOrder.setCustomer(order.getCustomer());
            dbOrder.setPayment(order.getPayment());

            orderRepository.save(dbOrder);
        });*/


    }

    @Override
    public OrderDTO updateOrderById(Long id, UpdateOrderDTO updateOrderDTO) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Order could not be found."));
        //if we are getting the same value, it is not necessary to update the actual value

        boolean changeDetected = false;

        if (!order.getPaidPrice().equals(updateOrderDTO.getPaidPrice())){
            order.setPaidPrice(updateOrderDTO.getPaidPrice());
            changeDetected =true;
        }

        if(!order.getTotalPrice().equals(updateOrderDTO.getTotalPrice())){
            order.setTotalPrice(updateOrderDTO.getTotalPrice());
            changeDetected=true;
        }

        //if there is any change, update the order and return it
        if(changeDetected){
            Order updateOrder = orderRepository.save(order);
            return mapperUtil.convert(updateOrder,new OrderDTO());
        }else{
            throw new NotFoundException("No changes detected");
        }

    }


    private void validateRelatedFieldsAreExist(OrderDTO orderDTO){
        // in this method we have 3 different service and make sure they have these fields
        // we  will create service and existById method and verify
        if(!customerService.existById(orderDTO.getCustomerId())){
            throw new NotFoundException("Customer could not be found");
        }

        if(!paymentService.existById(orderDTO.getPaymentId())){
            throw new NotFoundException("Payment could not be found");
        }
        if(!cartService.existById(orderDTO.getCartId())){
            throw new NotFoundException("Cart could not be found");
        }

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
