package org.binarfood.service;

import java.util.List;

import org.binarfood.model.Order;

public interface OrderService {
    // CREATE
    void create(Order order);

    // READ
    Order get(int choice);
    List<Order> getList();
    boolean isEmpty();
    int getTotalPrice();
    int getTotalQty();
    String getListString(List<Order> orders);
    String getTotalListString();
    String getReceipt(int order);

    // UPDATE
    void update(int choice, int qty);

    // DELETE
    void delete(int choice);
    void clearList();
}
