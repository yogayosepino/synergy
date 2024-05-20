package com.yoga.binarfut.repository;

import com.yoga.binarfut.model.Order;
import com.yoga.binarfut.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
    List<OrderDetail> findAllByOrder(Order order);
}
