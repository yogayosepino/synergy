package org.binarfood.controller;

import org.binarfood.model.User;
import org.binarfood.service.UserService;
import org.binarfood.service.UserServiceImpl;
import org.binarfood.view.UserView;

import static org.binarfood.utils.BinarFoodUtils.checkInt;
import static org.binarfood.utils.BinarFoodUtils.printChoiceInvalid;

public class UserController {

    public void displayLoginMenu() {
        UserService us = new UserServiceImpl();
        UserView uv = new UserView();

        uv.displayLoginMenu();
        while (true) {
            uv.welcome();
            String username = uv.askUsername();
            String password = uv.askPassword();
            User user = us.getByUserPass(username, password);
            if (user == null) {
                uv.displayWrongUserPass();
            } else {
                displayMainMenu(user);
                break;
            }
        }
    }

    public void displayMainMenu(User user) {
        CustomerController cc = new CustomerController();

        if (user.getRole()== User.Role.CUSTOMER) {
            cc.displayMainMenu(user);
        }
    }

    public void displayProfileMenu(User user) {
        UserView uv = new UserView();
        CustomerController cc = new CustomerController();
//        BasicView bv = new BasicView();

        uv.displayProfileMenu(user);

        boolean validChoice;
        do {
            validChoice = true;
            int choice = checkInt("=> ");
            switch(choice) {
                case 1:
                    askNewUsername(user);
                    displayProfileMenu(user);
                    break;
                case 2:
                    askNewEmail(user);
                    displayProfileMenu(user);
                    break;
                case 3:
                    askNewPassword(user);
                    displayProfileMenu(user);
                    break;
                case 0:
                    cc.displayMainMenu(user);
                    break;
                default:
                    printChoiceInvalid();
                    validChoice = false;
                    break;
            }
        } while (!validChoice);
    }

    public void askNewUsername(User user) {
        UserView uv = new UserView();
        UserService us = new UserServiceImpl();

        while(true) {
            String username = uv.askUsername();
            if (us.usernameExists(username)) {
                uv.displayUsernameExisted();
            } else {
                user.setUsername(username);
                break;
            }
        }
    }

    public void askNewEmail(User user) {
        UserView uv = new UserView();
        UserService us = new UserServiceImpl();

        while(true) {
            String email = uv.askEmail();
            if (us.emailExists(email)) {
                uv.displayEmailExisted();
            } else {
                user.setEmail(email);
                break;
            }
        }
    }

    public void askNewPassword(User user) {
        UserView uv = new UserView();
        UserService us = new UserServiceImpl();

        while(true) {
            String password = uv.askPassword();
            if (us.passwordInvalid(password)) {
                uv.displayPasswordInvalid();
            } else {
                user.setPassword(password);
                break;
            }
        }
    }
}
