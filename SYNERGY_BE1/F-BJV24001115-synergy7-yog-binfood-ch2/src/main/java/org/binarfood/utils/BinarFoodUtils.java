package org.binarfood.utils;

import java.util.Scanner;
import java.util.StringJoiner;

public class BinarFoodUtils {
    private static final Scanner input = new Scanner(System.in);

    public static int checkInt(String question, boolean mustPositive) {
        while (true) {
            System.out.print(question);
            try {
                int answer = input.nextInt();
                input.nextLine();
                if (mustPositive && answer < 0) {
                    System.out.println("Eror. Mohon input angka positif.");
                    continue;
                }
                return answer;
            }
            catch (Exception e) {
                System.out.println("Eror. Mohon input angka dengan benar.");
                input.reset();
                input.nextLine();
            }
        }
    }

    public static int checkInt(String question) {
        return checkInt(question, false);
    }

    public static void printChoiceInvalid() {
        System.out.println("Pilihan tidak valid.");
    }

    public static String checkString(String question, String[] choices, boolean caseInsensitive) {
        while (true) {
            System.out.print(question);
            String answer = input.nextLine();
            for (String choice : choices) {
                if (answer.equals(choice) || (caseInsensitive && answer.equalsIgnoreCase(choice))) {
                    return answer;
                }
            }
            StringJoiner choiceList = new StringJoiner(" / ");
            for (String element : choices) {
                choiceList.add(element);
            }
            System.out.println("Mohon masukkan input sesuai pilihan. ( %s )");
        }
    }

}
