package com.yoga.binarfut.service;

import com.yoga.binarfut.exception.NotFoundIdException;
import com.yoga.binarfut.model.Order;
import com.yoga.binarfut.model.User;
import com.yoga.binarfut.payload.OrderDto;
import com.yoga.binarfut.payload.OrderRequestDto;
import com.yoga.binarfut.payload.OrderResponseDto;
import com.yoga.binarfut.repository.OrderRepository;
import com.yoga.binarfut.repository.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    UserService userService;

    @Autowired
    MerchantService merchantService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setCustomer(userService.getById(orderRequestDto.getCustomer()));
        order.setMerchant(merchantService.getById(orderRequestDto.getMerchant()));
        order.setDestination(orderRequestDto.getDestination());
        order.setOrderTime(LocalDateTime.now());
        order.setStatusOrder(true);

        order = orderRepository.save(order);
//        log.info("Order {} successfully added", order.getId());

       OrderResponseDto orderResponseDto = new OrderResponseDto();
       orderResponseDto.setId(order.getId());
       orderResponseDto.setName(order.getCustomer().getUsername());
       orderResponseDto.setDestination(order.getDestination());
       orderResponseDto.setOrderTime(order.getOrderTime());
       orderResponseDto.setStatusOrder(true);

        return orderResponseDto;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = orderRepository.findAll();
//        Optional<User>userOptional =userRepository.findById(id);
//
//        if (userOptional.isEmpty()){
//            throw new RuntimeException("nothing");
//        } else{
//            return userOptional.get();
//        }
        return orders;

    }

    @Override
    public Order patchOrder(UUID id, OrderDto orderDto) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isEmpty()){
            throw new NotFoundIdException("Order not found with id " + id);
        }
        Order order = optionalOrder.get();

        if (orderDto.getDestination() != null) {
            order.setDestination(orderDto.getDestination());
        }
        order.setOrderTime(LocalDateTime.now());

        return orderRepository.save(order);
    }

    @Override
    public void softDeleteOrder(UUID id) {
        Optional<Order> order = orderRepository.findById(id);

        order.ifPresent(o -> {
            o.setDeleted(true);
            orderRepository.save(o);
        });
    }
}
