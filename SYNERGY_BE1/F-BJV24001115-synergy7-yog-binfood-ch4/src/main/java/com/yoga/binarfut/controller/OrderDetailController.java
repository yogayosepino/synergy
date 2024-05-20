package com.yoga.binarfut.controller;


import com.yoga.binarfut.model.OrderDetail;
import com.yoga.binarfut.payload.*;
import com.yoga.binarfut.service.OrderDetailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("order-detail")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    ModelMapper modelMapper;

    //create
    @PostMapping("create")
    public ResponseEntity<Map<String, Object>> createOrderDetail(@RequestBody OrderDetailRequestDto orderDetailRequestDto){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        OrderDetailResponseDto orderDetailResponseDto = orderDetailService.createOrder(orderDetailRequestDto);

        data.put("order detail", orderDetailResponseDto);
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //read
    @GetMapping("read")
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
//        cara 1
//        data.put("cinemas", cinemaService.getCinemaList());

        List<OrderDetail> orderDetailList = orderDetailService.getAll();
        List<OrderDetailDto> orderDetailDtoList = orderDetailList
                .stream()
                .map(orderDetail -> modelMapper.map(orderDetail, OrderDetailDto.class))
                .toList();
        data.put("order-detail", orderDetailDtoList);

        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //update
    @PatchMapping("{id}")
    public ResponseEntity<OrderDetail> updateOrderDetail(@PathVariable UUID id, @RequestBody OrderDetailDto orderDetailDto) {
        OrderDetail patchOrderDetail = orderDetailService.patchOrder(id, orderDetailDto);
        return ResponseEntity.ok(patchOrderDetail);
    }

    //delete
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteOrderDetail(@PathVariable UUID id) {
        orderDetailService.softDeleteOrderDetail(id);
        return ResponseEntity.noContent().build();
    }
}
