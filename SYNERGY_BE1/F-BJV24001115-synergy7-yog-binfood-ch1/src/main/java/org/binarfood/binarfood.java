package org.binarfood;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class binarfood {
    static int qty,qty1,qty2,qty3,qty4,qty5 = 0;
    static long total = 0, totaltemp1 = 0, totaltemp2 = 0, totaltemp3 = 0,totaltemp4 = 0,totaltemp5 = 0;
    static Scanner sc = new Scanner(System.in);
    static  StringBuilder sb = new StringBuilder();
        static void menu() {

            qty = qty1 + qty2 + qty3 + qty4 + qty5;
            total = totaltemp1 + totaltemp2 + totaltemp3 + totaltemp4 + totaltemp5;

            System.out.println("---------------------");
            System.out.println("Welcome to Binar Food");
            System.out.println("---------------------");
            System.out.println();
            System.out.println("Silahkan Pilih Makanan");
            System.out.println("1. Nasi Goreng      | 15.000");
            System.out.println("2. Mie Goreng       | 13.000");
            System.out.println("3. Nasi + Ayam      | 18.000");
            System.out.println("4. Es Teh Manis     | 3.000");
            System.out.println("5. Es Jeruk         | 5.000");
            System.out.println();
            System.out.println("0. Pesan dan Bayar");
            System.out.println("00. Keluar Aplikasi");
            System.out.println();

            System.out.print("=>");
            int sw = sc.nextInt();

            switch (sw) {
                case 1:
                    System.out.println("-------------------");
                    System.out.println("Berapa Pesanan Anda");
                    System.out.println("-------------------");
                    System.out.println();
                    System.out.println("1. Nasi Goreng      | 15.000");
                    System.out.print("qty => ");
                    qty1 = sc.nextInt();
                    totaltemp1 = totaltemp1 + qty1 * 15000;
                    System.out.println(totaltemp1);
                    menu();
                    break;


                case 2:
                    System.out.println("-------------------");
                    System.out.println("Berapa Pesanan Anda");
                    System.out.println("-------------------");
                    System.out.println();
                    System.out.println("2. Mie Goreng     | 13.000");
                    System.out.print("qty => ");
                    qty2 = sc.nextInt();
                    totaltemp2 = totaltemp2 + qty2 * 13000;
                    System.out.println(totaltemp2);
                    menu();
                    break;

                case 3:
                    System.out.println("-------------------");
                    System.out.println("Berapa Pesanan Anda");
                    System.out.println("-------------------");
                    System.out.println();
                    System.out.println("3. Nasi + Ayam    | 18.000");
                    System.out.print("qty => ");
                    qty3 = sc.nextInt();
                    totaltemp3 = totaltemp3 + qty3 * 18000;
                    System.out.println(totaltemp3);
                    menu();
                    break;

                case 4:
                    System.out.println("-------------------");
                    System.out.println("Berapa Pesanan Anda");
                    System.out.println("-------------------");
                    System.out.println();
                    System.out.println("3. Es Teh Manis    | 3.000");
                    System.out.print("qty => ");
                    qty4 = sc.nextInt();
                    totaltemp4 = totaltemp4 + qty4 * 3000;
                    System.out.println(totaltemp4);
                    menu();
                    break;

                case 5:
                    System.out.println("-------------------");
                    System.out.println("Berapa Pesanan Anda");
                    System.out.println("-------------------");
                    System.out.println();
                    System.out.println("3. Es Jeruk    | 5.000");
                    System.out.print("qty => ");
                    qty5 = sc.nextInt();
                    totaltemp5 = totaltemp5 + qty5 * 3000;
                    System.out.println(totaltemp5);
                    menu();
                    break;

                case 0:
                    if (qty>0){
                        order();
                    }else {
                        System.exit(0);
                    }
                    break;
//                case 00:
//                    System.exit(0);
                default:
                    break;
            }
//            System.out.println(total);
        }

        static void order(){
            System.out.println("-----------------------");
            System.out.println("Konfirmasi & Pembayaran");
            System.out.println("-----------------------");
            System.out.println();
            System.out.println("Nasi Goreng  \t\t\t" + qty1 + "       " + totaltemp1);
            System.out.println("Mie Goreng   \t\t\t" + qty2 + "       " + totaltemp2);
            System.out.println("Nasi + Ayam  \t\t\t" + qty3 + "       " + totaltemp3);
            System.out.println("Es Teh Manis \t\t\t" + qty4 + "       " + totaltemp4);
            System.out.println("Es Jeruk     \t\t\t" + qty5 + "       " + totaltemp5);
            System.out.println("------------------------------------------------------------+");
            System.out.println("Total        \t\t\t" + qty + "       " + total);
            System.out.println();
            System.out.println("1. Konfirmasi dan Bayar ");
            System.out.println("2. Kembali ke Menu Utama");
            System.out.println("0. Keluar Aplikasi");

            System.out.print("=>");
            int ord = sc.nextInt();

            switch (ord){
                case 1:
                    bill();
                    break;
                case 2:
                    menu();
                    break;
                case 0 :
                    System.exit(0);
                default:
                    break;
            }


        }

    static void bill() {

        System.out.println();
        System.out.println("Terimakasih sudah memesan di Binar Food");
        System.out.println();
        System.out.println("Dibawah ini adalah pesanan anda");
        System.out.println();
        System.out.println("Nasi Goreng \t\t\t" + qty1 + "       " + totaltemp1);
        System.out.println("Mie Goreng   \t\t\t" + qty2 + "       " + totaltemp2);
        System.out.println("Nasi + Ayam  \t\t\t" + qty3 + "       " + totaltemp3);
        System.out.println("Es Teh Manis \t\t\t" + qty4 + "       " + totaltemp4);
        System.out.println("Es Jeruk     \t\t\t" + qty5 + "       " + totaltemp5);
        System.out.println("-------------------------------------------------------+");
        System.out.println("Total        \t\t\t" + qty +  "       " + total);
        System.out.println("Pembayaran : Binar Cash");
        System.out.println();
        System.out.println("=========================================");
        System.out.println("Simpan struk ini sebagai bukti pembayaran");
        System.out.println("==========================================");

        invoice();

        System.exit(0);


//        return main();
//        try{
//            PrintStream myConsole = new PrintStream(new File(("output2.txt")));
//            System.setOut(myConsole);
//            myConsole.print(bill());
//        }
//        catch (FileNotFoundException e ){
//            System.out.println(e);
//        }
//        try {
//            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//            String lineFromInput = in.readLine();
//
//            PrintWriter out = new PrintWriter(new FileOutputStream("output2.txt"));
//            setOut(out);
//
//            out.println(lineFromInput);
//
//            out.close();
//        }
//        catch(IOException e) {
//            System.out.println("Error during reading/writing");
//        }

    }

//    static String billing(boolean b){
////        StringBuilder sb = new StringBuilder();
////        String test;
//
//
//                System.out.println();
//                System.out.println("Dibawah ini adalah pesanan anda");
//                System.out.println();
//                System.out.println("Nasi Goreng          " + qty1 + "       " + totaltemp1);
//                System.out.println("Mie Goreng           " + qty2 + "       " + totaltemp2);
//                System.out.println("Nasi + Ayam          " + qty3 + "       " + totaltemp3);
//                System.out.println("Es Teh Manis         " + qty4 + "       " + totaltemp4);
//                System.out.println("Es Jeruk             " + qty5 + "       " + totaltemp5);
//                System.out.println("-------------------------------------------------------+");
//                System.out.println("Total                " + qty +  "       " + total);
//                System.out.println("Pembayaran : Binar Cash");
//                System.out.println();
//                System.out.println("=========================================");
//                System.out.println("Simpan struk ini sebagai bukti pembayaran");
//                System.out.println("==========================================");
//
//
//            return null;
//    }
    static String bill(boolean a) {

        return tempx("Binarfood") +
                """
                Terimakasih sudah memesan di Binar Food
                Dibawah ini adalah pesanan anda
                        
                """ + """
                Nasi Goreng   \t\t\t"""  +  qty1 + "        " + totaltemp1 + "        \n" +

                """
                Mie Goreng    \t\t\t""" +  qty2  + "        " + totaltemp2 +  "        \n" +

                """
                Nasi + Ayam   \t\t\t""" +  qty3 +"        " + totaltemp3 + "        \n" +

                """
                Es Teh Manis  \t\t\t""" +  qty4 + "        " +totaltemp4 + "        \n" +

                """
                Es Jeruk      \t\t\t""" +  qty5 +"        " + totaltemp5 +"        \n" +
                """
                Total         \t\t\t""" +   qty +"        " + total + "        \n" ;

    }

    static String tempx(String text){
            return "\n==========================\n" + text + "\n==========================\n";
    }

    static void invoice() {
        System.out.println(bill(true));

            try {
                File invoiced = new File("output.txt");
                int existing = 1;
                while (invoiced.exists()) {
                    invoiced = new File("output"+ existing +".txt");
                    existing++;
                }
                PrintWriter inv = new PrintWriter(invoiced);
                inv.println(bill(false));
                inv.close();
            } catch (IOException e) {
                System.out.println("Eror saat menghasilkan invoice dalam file text.");
            }

    }


//    static void invoice(){
//        bill();
//
//        try {
//            File receiptfile = new File("receipt.txt");
//            int fileCounter = 1;
//            while (receiptfile.exists()){
//                receiptfile = new File("receipt(" + fileCounter + ").txt");
//                fileCounter++;
//            }
//
//            PrintWriter output = new PrintWriter(receiptfile);
//            output.println(bill());
//            output.close();
//
//        } catch (IOException e){
//            System.out.println("Error");
//        }
//    }
    static void date(){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
        LocalDateTime current = LocalDateTime.now();
        System.out.println(date.format(current));
    }


    public static void main(String[] args) {


    }
}
