import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinCodeApp {

    public static void main(String[] args) throws IOException {

        final short CORRECT_PIN = 1234;
        short pin = 0;
        byte tries = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter PIN code: ");
        while (pin != CORRECT_PIN) {
            if (tries == 3) {
                System.out.println("TOO MANY TRIES!");
                break;
            }
            pin = Short.parseShort(reader.readLine());
            tries++;
        }
        if (pin == CORRECT_PIN)
            System.out.println("ACCESS GRANTED!");
    }
}