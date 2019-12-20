package arrays;

public class MiniMaxArrayExample {

    static int[] data = {10, 0, 20, 5, 100};

    public static void printMinValue(){
        int minVallue = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < minVallue)
                minVallue = data[i];
        }
        System.out.println("The minimum value is: " + minVallue);
    }

    public static void printMaxValue(){
        int maxVallue = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > maxVallue)
                maxVallue = data[i];
        }
        System.out.println("The maximum value is: " + maxVallue);
    }
}
