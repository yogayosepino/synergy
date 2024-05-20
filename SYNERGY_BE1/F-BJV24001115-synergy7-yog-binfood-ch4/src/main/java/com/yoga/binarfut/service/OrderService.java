package com.yoga.binarfut.service;

import com.yoga.binarfut.model.Order;
import com.yoga.binarfut.payload.OrderDto;
import com.yoga.binarfut.payload.OrderRequestDto;
import com.yoga.binarfut.payload.OrderResponseDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    //create
    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

    //read
    List<Order> getAll();

    //update
    Order patchOrder (UUID id, OrderDto orderDto);

    //delete
    void softDeleteOrder(UUID id);
}
