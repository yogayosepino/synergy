package com.yoga.binarfut.controller;

import com.yoga.binarfut.model.Merchant;
import com.yoga.binarfut.model.Order;
import com.yoga.binarfut.payload.*;
import com.yoga.binarfut.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody OrderRequestDto orderRequestDto){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        OrderResponseDto orderResponseDto = orderService.createOrder(orderRequestDto);

        data.put("order", orderResponseDto);
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //read
    @GetMapping("read")
    public ResponseEntity<Map<String, Object>> getAll() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
//        cara 1
//        data.put("cinemas", cinemaService.getCinemaList());

        List<Order> orderList = orderService.getAll();
        List<OrderDto> orderDtoList = orderList
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .toList();
//        List<Order> orders = orderService.getAll();
//        return orders.stream()
//                .map(order -> new OrderDto(
//                        order.getCustomer().getUsername(),
//                        order.getDestination(),
//                        order.getOrderTime(),
//                        order.isStatusOrder()))
//                .collect(Collectors.toList());
        data.put("order", orderDtoList);

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //update
    @PatchMapping("{id}")
    public ResponseEntity<Order> updateUser(@PathVariable UUID id, @RequestBody OrderDto orderDto) {
        Order patchOrder = orderService.patchOrder(id, orderDto);
        return ResponseEntity.ok(patchOrder);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
        orderService.softDeleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
