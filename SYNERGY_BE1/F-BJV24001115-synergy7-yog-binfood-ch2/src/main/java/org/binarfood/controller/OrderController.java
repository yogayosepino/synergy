package org.binarfood.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.binarfood.service.*;

public class OrderController {
    public String displayTotalOrderList() {
        OrderService os = new OrderServiceImpl();

        return os.getTotalListString();
    }

    public String displayReceipt() {
        OrderService os = new OrderServiceImpl();

        int order = 1;
        try {
            File receiptFile = new File(String.format("receipt.txt", order));
            while (receiptFile.exists()) {
                order++;
                receiptFile = new File(String.format("receipt"+ order + ".txt",  order));
            }

            PrintWriter receipt = new PrintWriter(receiptFile);
            receipt.println(os.getReceipt(order));
            receipt.close();
        } catch (IOException e) {
            System.out.println("Eror saat menghasilkan struk dalam file text.");
        }

        return os.getReceipt(order);
    }

    public boolean askOrderChoice(int choice) {
        OrderService os = new OrderServiceImpl();

        if (choice >= 0) {
            return true;
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        return false;
    }
}
