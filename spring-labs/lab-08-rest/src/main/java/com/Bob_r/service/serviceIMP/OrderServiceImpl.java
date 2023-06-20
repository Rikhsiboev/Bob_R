package com.Bob_r.service.serviceIMP;



import com.Bob_r.client.CurrencyApiClient;
import com.Bob_r.dto.OrderDTO;
import com.Bob_r.dto.UpdateOrderDTO;
import com.Bob_r.entity.Order;
import com.Bob_r.enums.Currency;
import com.Bob_r.enums.PaymentMethod;
import com.Bob_r.exception.CurrencyTypeNotFoundException;
import com.Bob_r.exception.NotFoundException;
import com.Bob_r.mapper.MapperUtil;
import com.Bob_r.repository.OrderRepository;
import com.Bob_r.service.CartService;
import com.Bob_r.service.CustomerService;
import com.Bob_r.service.OrderService;
import com.Bob_r.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderServiceImpl implements OrderService {
    @Value("${access_key}")
    private String accessKey;

    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final PaymentService paymentService;
    private final CartService cartService;

    private final MapperUtil mapperUtil;
    private final CurrencyApiClient currencyApiClient;

    public OrderServiceImpl(OrderRepository orderRepository,
                            MapperUtil mapperUtil,
                            CustomerService customerService,
                            PaymentService paymentService,
                            CartService cartService,
                            CurrencyApiClient currencyApiClient) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
        this.paymentService = paymentService;
        this.cartService = cartService;
        this.currencyApiClient = currencyApiClient;
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

    @Override
    public OrderDTO retrievedOrderById(Long id, Optional<String> currency) {
        // find the order based id
//        Optional<Order> byId = orderRepository.findById(id);
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Order could not be found."));
        // if we are getting currency7  value from the user
        currency.ifPresent(curr -> {
            //check that if user currency input is valid (inside the currencies list
            validateCurrency(curr);
            //get the currency data based on currency type
            BigDecimal currencyRate = getCurrencyRate(curr);
            // do calculations and set new paiPrice and totalPrice
            // these prices for just to give value to customer, we will not update their db based on other currencies
            BigDecimal newPaidPrice = order.getPaidPrice()
                    .multiply(currencyRate)
                    .setScale(2, RoundingMode.HALF_UP);
            BigDecimal newTotalPrice = order.getTotalPrice()
                    .multiply(currencyRate)
                    .setScale(2,RoundingMode.HALF_UP);
                //Set the value to order that we retrieved
                //order.setTotalPrice(100);
                //order.setPaidPrice(100);
            order.setPaidPrice(newPaidPrice);
            order.setTotalPrice(newTotalPrice);

                });
        //convert and return it
        OrderDTO convert = mapperUtil.convert(order, new OrderDTO());
        // consume Api

        return convert;
    }

    private void validateCurrency(String curr) {
        //check if the currency is valid currency
        List<String> currencies = Stream.of(Currency.values())
                .map(currency -> currency.value)
                .collect(Collectors.toList());
        boolean isCurrencyValid = currencies.contains(curr);
        if (!isCurrencyValid){
            throw new CurrencyTypeNotFoundException("Currency type for "+ curr + " could not be found");
        }
    }


    private BigDecimal getCurrencyRate(String currency) {
        // consume the api
        // we save response inside the quotes map
        Map<String, Double> quotes = currencyApiClient
                .getCurrencyRates(accessKey, currency, "USD", 1)
                .getQuotes();
        boolean isSuccess = currencyApiClient
                .getCurrencyRates(accessKey, currency, "USD", 1)
                .isSuccess();

        // check if success if true then retrieve

        if (!isSuccess){
            throw new RuntimeException("Api is Down");
        }

        String expectedCurrency="USD"+currency.toString().toUpperCase();
        //Double currencyRate = quotes.get(expectedCurrency);
        BigDecimal currencyRate = BigDecimal.valueOf(quotes.get(expectedCurrency));
        return currencyRate;
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
