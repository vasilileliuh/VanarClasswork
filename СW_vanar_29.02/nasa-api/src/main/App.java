package main;

import providers.NASADataProvider;

import java.io.IOException;
import java.security.Provider;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter start/end dates YYYY-MM-DD: ");
        String startDate = in.next(), endDate = in.next();

        new NASADataProvider().getNeoAsteroids(startDate, endDate);

    }
}
