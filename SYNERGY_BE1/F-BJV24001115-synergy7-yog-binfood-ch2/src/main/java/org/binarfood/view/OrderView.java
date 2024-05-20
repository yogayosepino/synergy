package org.binarfood.view;

import org.binarfood.controller.OrderController;

import static org.binarfood.utils.BinarFoodUtils.*;

public class OrderView {
    public int askOrderChoice() {
        OrderController oc = new OrderController();

        int choice;
        do {
            choice = checkInt("Nomor order: ");
        } while (!oc.askOrderChoice(choice - 1));

        return choice;
    }
}
