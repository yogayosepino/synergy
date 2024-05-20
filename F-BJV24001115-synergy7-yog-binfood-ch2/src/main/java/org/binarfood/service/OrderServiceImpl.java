package org.binarfood.service;

import org.binarfood.model.Order;
import org.binarfood.Data;
import org.binarfood.model.Menu;

import java.util.List;
import java.time.LocalDate;

import static org.binarfood.Data.orders;

public class OrderServiceImpl implements OrderService{
    @Override
    public void create(Order order) {
        boolean found = false;

        for (Order o : orders) {
            if (o.getMenuItem().equals(order.getMenuItem())) {
                found = true;
                o.addQty(order.getQty());

                break;
            }
        }

        if (!found) orders.add(order);
    }

    @Override
    public Order get(int choice) {
        if (choice < 0 ) {
            throw new IndexOutOfBoundsException("Pilihan invalid: " + choice);
        }

        Order order = orders.get(choice);
        if (order == null) {
            System.out.println("Order tidak ditemukan: " + choice);
        }

        return order;
        }

    @Override
    public List<Order> getList() {
        return Data.orders;
    }

    @Override
    public boolean isEmpty() {
        return getList().isEmpty();
    }

    @Override
    public int getTotalPrice() {
        int totalPrice = 0;

        for (Order orders : getList()) {
            totalPrice += orders.getPrice() * orders.getQty();
        }

        return totalPrice;
    }

    @Override
    public int getTotalQty() {
        int totalQty = 0;

        for (Order order : getList()) {
            totalQty += order.getQty();
        }

        return totalQty;
    }

    @Override
    public String getListString(List<Order> orders) {
        StringBuilder output = new StringBuilder();
        String format = "%-19s %-7s %s%n";
//        if (withColor) format = "%-21s %-16s %s%n";

        for (int i = 0; i<orders.size(); i++) {
            Order order = orders.get(i);
            Menu menuItem = order.getMenuItem();
            int price = order.getPrice()*order.getQty();
            String qty = Integer.toString(order.getQty());

            output.append(String.format(
                  format,
                    (i+1) + ". " + menuItem.getName() ,
                    qty,
                    Integer.toString(price)
            ));
//            System.out.println((i+1) + " " + menuItem.getName() + " " + qty + " " + price);
        }

        return output.toString();
    }

    @Override
    public String getTotalListString() {
        StringBuilder output = new StringBuilder();
//        String format = "%-21s %-16s %s%n"+ ":" +"%-19s %-7s %s%n";

        output.append(getListString(Data.orders));

//        if (!Data.freebiesOrder.isEmpty()) {
//            output.append("FREE\n");
//            output.append(getListString(withColor, Data.freebiesOrder));
//        }

        output.append("-".repeat(35));
        output.append("+\n");

        int totalQty = getTotalQty();
        int totalPrice = getTotalPrice();
        output.append(String.format(
//                format,
                "Total ",
                (Integer.toString(totalQty)) + ":" + Integer.toString(totalQty),
                (totalPrice)) + ":" + totalPrice
        );

        return output.toString();
    }


    @Override
    public String getReceipt(int order) {
        LocalDate date = LocalDate.now();
        return "BinarFood" +
                "Waktu : " + date + "\n" +
                "Order : " + order + "\n" +
                """
                
                Terima kasih sudah memesan
                di BinarFud

                Di bawah ini adalah pesanan anda
                
                """ +
                getTotalListString() +
                "\nPembayaran : BinarCash\n" +
                "Simpan struk ini sebagai bukti pembayaran";
    }

    @Override
    public void update(int choice, int qty) {
        Order order = get(choice);

        if (order.getQty() > 0) {
            order.setQty(qty);
        } else {
            Order updatedOrder = new Order(order.getMenuItem(), qty);
            Data.orders.remove(order);
            create(updatedOrder);
        }

    }

    @Override
    public void delete(int choice) {
        if (choice < 0 || choice >= Data.orders.size()) {
            throw new IndexOutOfBoundsException("Pilihan invalid: " + choice);
        }

        Data.orders.remove(choice);

    }

    @Override
    public void clearList() {
        Data.orders.clear();
    }
}
