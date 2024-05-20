package org.binarfood.view;

import org.binarfood.controller.MenuController;
import org.binarfood.controller.*;

import static org.binarfood.utils.BinarFoodUtils.checkInt;
import static org.binarfood.utils.BinarFoodUtils.checkString;

public class CustomerView {
    public void displayMainMenu() {
        MenuController mc = new MenuController();
        CustomerController cc = new CustomerController();

        System.out.println("Selamat datang di BinarFood");

//        pc.displayPromoList();

        System.out.println("Silahkan pilih menu :");
        mc.displayMenuItemList();
        System.out.println("99. Pesan dan Bayar");
        System.out.println("0. Keluar aplikasi");
        System.out.println();

        while (true) {
            if (cc.mainMenuSelection(checkInt("=> "))) break;
        }
    }

    public void displayQtyMenu(int choice) {
        MenuController mc = new MenuController();
        CustomerController cc = new CustomerController();

        System.out.println("Berapa pesanan anda");

        mc.displayMenuItem(choice);
        System.out.println("(input 0 untuk kembali)");
        System.out.println();

        cc.askQty(choice, false);
        displayMainMenu();
    }
    public int askQty()
    {
        return checkInt("qty => ", true);
    }

    public void displayTotalMenu() {
        OrderController oc = new OrderController();
        CustomerController cc = new CustomerController();

        System.out.println("Konfirmasi & Pembayaran");

        System.out.println(oc.displayTotalOrderList());

        System.out.println("""
                1. Konfirmasi dan Bayar
                2. Kembali ke menu
                3. Ubah pesanan
                4. Kosongkan pesanan
                0. Keluar aplikasi
                """);

        while (true) {
            if (cc.totalMenuSelection(checkInt("=> "))) break;
        }
    }

    public void displayConfirmationMenu() {
        CustomerController cc = new CustomerController();

        System.out.println("Mohon masukkan input pilihan Anda");

        System.out.println("(Y) untuk lanjut");
        System.out.println("(N) untuk keluar");
        cc.confirmationMenuSelection(checkString("=> ", new String[]{"Y", "N"}, true));
    }


    public void displayEditMenu() {
        CustomerController cc = new CustomerController();
        OrderController oc = new OrderController();

        System.out.println("Ubah Pesanan");

        System.out.println(oc.displayTotalOrderList());

        System.out.println("""
        1. Ubah detail pesanan
        2. Menghapus pesanan
        0. Kembali
        """);

        while (true) {
            if (cc.editMenuSelection(checkInt("=> "))) break;
        }
    }

    public void displayReceiptMenu() {
        OrderController oc = new OrderController();
        System.out.println(oc.displayReceipt());
    }

    public void displayExitMenu() {
        System.out.println("Terima kasih sudah menggunakan aplikasi ini");
    }
}
