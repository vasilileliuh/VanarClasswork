package arrays;

public class WeatherArrayExampleChisinauCity {
    public static float[] weeklyTemperatures = {5.0f, 7.0f, 3.0f, 0.0f, -1.0f, -2.0f, -5.0f};

    public static void printPositiveValues() {
        printValues(true);
    }

    public static void printNegativeValues() {
        printValues(false);
    }

    private static void printValues(boolean positive) {
        for (float weeklyTemperature : weeklyTemperatures) {
            if (positive && weeklyTemperature >= 0) {
                System.out.printf("%s %.1f\u2103%n", "Positive temperature is: ", weeklyTemperature);
            }
            if (!positive && weeklyTemperature < 0) {
                System.out.printf("%s %.1f\u2103%n", "Negative temperature is: ", weeklyTemperature);
            }
        }
    }
}
