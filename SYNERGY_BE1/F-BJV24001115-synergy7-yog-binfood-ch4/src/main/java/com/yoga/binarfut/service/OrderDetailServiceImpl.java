package com.yoga.binarfut.service;

import com.yoga.binarfut.exception.NotFoundIdException;
import com.yoga.binarfut.model.Menu;
import com.yoga.binarfut.model.Order;
import com.yoga.binarfut.model.OrderDetail;
import com.yoga.binarfut.payload.OrderDetailDto;
import com.yoga.binarfut.payload.OrderDetailRequestDto;
import com.yoga.binarfut.payload.OrderDetailResponseDto;
import com.yoga.binarfut.repository.MenuRepository;
import com.yoga.binarfut.repository.OrderDetailRepository;
import com.yoga.binarfut.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderDetailResponseDto createOrder(OrderDetailRequestDto orderDetailRequestDto) {
        Order order = orderRepository.findById(orderDetailRequestDto.getOrder())
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        Menu menu = menuRepository.findById(orderDetailRequestDto.getMenu())
                    .orElseThrow(() -> new IllegalArgumentException("Menu not found"));

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setQty(orderDetailRequestDto.getQty());
        orderDetail.setOrder(order);
        orderDetail.setMenu(menu);
        orderDetail.setPrice(orderDetailRequestDto.getQty()*orderDetail.getMenu().getPrice());

        orderDetailRepository.save(orderDetail);

        OrderDetailResponseDto orderDetailResponseDto = new OrderDetailResponseDto();
        orderDetailResponseDto.setId(orderDetail.getId());
        orderDetailResponseDto.setQty(orderDetail.getQty());
        orderDetailResponseDto.setPrice(orderDetail.getQty()*orderDetail.getMenu().getPrice());

        orderDetailResponseDto.setMenu(orderDetail.getMenu().getId());
        orderDetailResponseDto.setOrder(orderDetail.getOrder().getId());

        return orderDetailResponseDto;

    }

    @Override
    public List<OrderDetail> getAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public List<OrderDetail> getAllByOrder(Order order) {
        return orderDetailRepository.findAllByOrder(order);
    }

    @Override
    public OrderDetail patchOrder(UUID id, OrderDetailDto orderDetailDto) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);

        if (optionalOrderDetail.isEmpty()){
            throw new NotFoundIdException("Order Detail not found with id " + id);
        }
        OrderDetail orderDetail = optionalOrderDetail.get();

        orderDetail.setQty(orderDetailDto.getQty());
        orderDetail.setPrice(orderDetailDto.getQty()*orderDetail.getMenu().getPrice());

//        order.setOrderTime(LocalDateTime.now());

        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void softDeleteOrderDetail(UUID id) {
        Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);

        orderDetail.ifPresent(od -> {
            od.setDeleted(true);
            orderDetailRepository.save(od);
        });
    }
}
