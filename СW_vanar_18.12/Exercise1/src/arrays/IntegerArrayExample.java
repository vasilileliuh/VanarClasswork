package arrays;

import java.lang.reflect.Array;
import java.util.Scanner;

public class IntegerArrayExample {
    public static int[] data = {1000, 2000, 3000, 4000, 5000};

    public static void printData() {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("[%d] = %d\n", i, data[i]);
        }
    }

    public static void printData(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("[%d] = %d\n", i, data[i]);
        }
    }

    public static void reverseprintData() {
        for (int i = 4; i >= 0; i--) {
            System.out.printf("[%d] = %d\n", i, data[i]);
        }
    }

    public static int sum() {
        int counter = 0;
        for (int i = 0; i < data.length; i++) {
            counter += data[i];
        }
        return counter;
    }

    public static int[] scanArray() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter array length = ");
        int length = in.nextInt();
        int[] freshData = new int[length];
        System.out.println("Array with length 0f " + freshData.length + " was reserved.");
        for (int i = 0; i < freshData.length; i++) {
            System.out.printf("[%d] = ? ", i);
            freshData[i] = in.nextInt();
        }
        return freshData;
    }
}
