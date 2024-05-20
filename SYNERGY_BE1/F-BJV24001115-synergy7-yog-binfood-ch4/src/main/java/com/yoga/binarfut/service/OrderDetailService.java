package com.yoga.binarfut.service;

import com.yoga.binarfut.model.Order;
import com.yoga.binarfut.model.OrderDetail;
import com.yoga.binarfut.payload.OrderDetailDto;
import com.yoga.binarfut.payload.OrderDetailRequestDto;
import com.yoga.binarfut.payload.OrderDetailResponseDto;

import java.util.List;
import java.util.UUID;

public interface OrderDetailService {
    //create
    OrderDetailResponseDto createOrder(OrderDetailRequestDto orderDetailRequestDto);

    //read
    List<OrderDetail> getAll();

    List<OrderDetail> getAllByOrder(Order order);

    //update
    OrderDetail patchOrder (UUID id, OrderDetailDto orderDetailDtoDto);

    //celete
    void softDeleteOrderDetail(UUID id);
}
