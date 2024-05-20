package org.binarfood.controller;

import org.binarfood.model.Order;
import org.binarfood.model.User;
import org.binarfood.service.MenuService;
import org.binarfood.service.MenuServiceImpl;
import org.binarfood.service.OrderService;
import org.binarfood.service.OrderServiceImpl;
import org.binarfood.view.CustomerView;
import org.binarfood.view.OrderView;

import static org.binarfood.utils.BinarFoodUtils.*;

public class CustomerController {
    public boolean mainMenuSelection(int choice) {
        CustomerView cv = new CustomerView();
        MenuService mis = new MenuServiceImpl();
        OrderService os = new OrderServiceImpl();

        if (choice == 0) {
            cv.displayExitMenu();
            return true;
        } else if (choice >= 1 && choice <= mis.getList().size()) {
            cv.displayQtyMenu(choice);
            return true;
        } else if (choice == 99) {
            if (os.getList().isEmpty()) {
                System.out.println("Anda belum memesan apa pun.");
            } else {
                cv.displayTotalMenu();
                return true;
            }
        } else {
            printChoiceInvalid();
        }
        return false;
    }

    public void askQty(int choice, boolean update) {
        CustomerView cv = new CustomerView();
        MenuService mis = new MenuServiceImpl();
        OrderService os = new OrderServiceImpl();

            int qty = cv.askQty();
            if (qty != 0) {
                if (update) os.update(choice-1, qty);
                else {
                    Order order = new Order(mis.get(choice-1), qty);
                    os.create(order);
                }
        }
    }

    public boolean totalMenuSelection(int choice) {
        CustomerView cv = new CustomerView();
        OrderService os = new OrderServiceImpl();

        switch (choice) {
            case 1:
                cv.displayConfirmationMenu();
                return true;
            case 2:
                cv.displayMainMenu();
                return true;
            case 3:
                cv.displayEditMenu();
                return true;
            case 4:
                os.clearList();
                cv.displayMainMenu();
                return true;
            case 0:
                cv.displayExitMenu();
                return true;
            default:
                printChoiceInvalid();
                break;
        }

        return false;
    }

    public void confirmationMenuSelection(String choice) {
        CustomerView cv = new CustomerView();

        if (choice.equals("Y") || choice.equals("y")) {
            cv.displayReceiptMenu();
        } else {
            cv.displayTotalMenu();
        }
    }

    public boolean editMenuSelection(int choice) {
        CustomerView cv = new CustomerView();
        OrderView ov = new OrderView();
        OrderService os = new OrderServiceImpl();
//        PromoService ps = new PromoServiceImpl();

        switch (choice) {
            case 1:
                askQty(ov.askOrderChoice(), true);
                cv.displayEditMenu();
                return true;
            case 2:
                os.delete(ov.askOrderChoice()-1);
//                ps.resetPromo();
                if (os.isEmpty()) cv.displayMainMenu();
                else cv.displayEditMenu();
                return true;
            case 0:
                cv.displayTotalMenu();
                return true;
            default:
                printChoiceInvalid();
                break;
        }

        return false;
    }

    public void displayMainMenu(User user) {
        CustomerView cv = new CustomerView();
        UserController uc = new UserController();

        cv.displayMainMenu();

        boolean validChoice;
        do {
            validChoice = true;
            int choice = checkInt("=> ");
            switch(choice) {
                case 1:
                    displayRestaurantsMenu(user);
                    break;
                case 2: // not done
                    displayOrderHistoryMenu(user);
                    break;
                case 3:
                    uc.displayProfileMenu(user);
                    break;
                case 4:
                    uc.displayLoginMenu();
                    break;
                case 0:
                    cv.displayExitMenu();
                    break;
                default:
                    printChoiceInvalid();
                    validChoice = false;
                    break;
            }
        } while (!validChoice);
    }

    private void displayOrderHistoryMenu(User user) {
    }

    private void displayRestaurantsMenu(User user) {
    }
}
