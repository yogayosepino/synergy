package org.binarfood.view;

import org.binarfood.model.User;

import java.util.Scanner;

public class UserView {
    Scanner in = new Scanner(System.in);

    public void displayLoginMenu() {
        System.out.println("LOGIN");
    }

    public void welcome() {
        System.out.println("Silakan masukkan username dan password");
    }

    public String askUsername() {
        System.out.print("Username: ");
        return in.nextLine();
    }

    public String askPassword() {
        System.out.print("Password: ");
        return in.nextLine();
    }

    public String askEmail() {
        System.out.print("Email: ");
        return in.nextLine();
    }

    public void displayUsernameExisted() {
        System.out.println("Username terpakai.");
    }

    public void displayEmailExisted() {
        System.out.println("Email terpakai.");
    }

    public void displayPasswordInvalid() {
        System.out.println("Minimal Password 12 Karakter");
    }

    public void displayWrongUserPass() {
        System.out.println("Username atau Password salah");
    }

    public void displayProfileMenu(User user) {
        System.out.println("Profile");
        System.out.println("Username  : " + user.getUsername());
        System.out.println("Email     : " + user.getEmail());
        System.out.println("Role      : " + user.getRole().toString());
//        if (user.getRole() == User.Role.SELLER) {
//            System.out.println("Restaurant: " + user.getRestaurant().getName());
//        }
        System.out.println("""
                
                1. Ganti username
                2. Ganti email
                3. Ganti password
                0. Kembali ke halaman utama
                """);
    }
}
