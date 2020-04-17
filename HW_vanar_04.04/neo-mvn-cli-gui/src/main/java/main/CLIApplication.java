package main;

import space.Asteroid;
import space.NASADataProvider;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CLIApplication {
    private final static int ONE_MILLION = 1_000_000;

    public static void main(String[] args) {
//        System.out.println("CLI running!");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter start/end dates YYYY-MM-DD: ");
        String startDate = in.next(), endDate = in.next();
        List<Asteroid> asteroids = null;
        try {
            asteroids = new NASADataProvider().getNeoAsteroids(startDate, endDate);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        for (Asteroid asteroid : asteroids) {
            System.out.printf("%s - %4.1fmln km from earth, %.2fkm diameter, %s%n",
                    asteroid.getDate().format(formatter),
                    asteroid.getDistance() / ONE_MILLION, asteroid.getDiameter(),
                    asteroid.getHazardous() ? "it is hazardous!" : "it's not hazardous!");
        }
    }
}
