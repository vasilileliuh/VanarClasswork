package main;

import space.NASADataProvider;

import java.io.IOException;
import java.util.Scanner;

public class CLIApplication {
    public static void main(String[] args) {
//        System.out.println("CLI running!");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter start/end dates YYYY-MM-DD: ");
        String startDate = in.next(), endDate = in.next();

        try {
            new NASADataProvider().getNeoAsteroids(startDate, endDate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
