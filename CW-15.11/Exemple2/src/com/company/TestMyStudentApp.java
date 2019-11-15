package com.company;

import java.util.Scanner;

public class TestMyStudentApp {

    public static void main(String[] args) {

        final String CURRENCY = "MDL";
        final String FOOD_1_NAME = "Pizza";
        final float FOOD_1_PRICE = 75.5f;
        final String FOOD_2_NAME = "Mamaliga";
        final float FOOD_2_PRICE = 150f;
        final String FOOD_3_NAME = "Salad";
        final float FOOD_3_PRICE = 30f;

        System.out.printf("%n ********* MENU *********%n" +
                        "1. %-10s %7.2f %s%n" +
                        "2. %-10s %7.2f %s%n" +
                        "3. %-10s %7.2f %s%n" +
                        " ************************%n%n",
                FOOD_1_NAME, FOOD_1_PRICE, CURRENCY,
                FOOD_2_NAME, FOOD_2_PRICE, CURRENCY,
                FOOD_3_NAME, FOOD_3_PRICE, CURRENCY);

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        if (option == 1) {
            System.out.println("Your choise " + FOOD_1_NAME);
        } else if (option == 2)
            System.out.println("Your choise " + FOOD_2_NAME);
        else if (option == 3)
            System.out.println("Your choise " + FOOD_3_NAME);
// test comment
    }
}
