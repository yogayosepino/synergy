package com.yoga.binarfut.repository;

import com.yoga.binarfut.model.Menu;
import com.yoga.binarfut.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
}
