package arrays;

public class MiniMaxArrayOfObjectsExample {

    static Drink[] drinks = {
            new Drink(0.5f),
            new Drink(0.75f),
            new Drink(2.50f),
            new Drink(0.33f),
            new Drink(0.1f),
            new Drink(0.05f),
            new Whiskey(50),
    };

    public static void printMinValue() {
        Drink minVal = drinks[0];
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i].getVolume() < minVal.getVolume()) {
                minVal = drinks[i];
            }
        }
        System.out.println("Min volume= " + minVal.toString());
    }

    public static void printMaxValue() {
        Drink maxVal = drinks[0];
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i].getVolume() > maxVal.getVolume()) {
                maxVal = drinks[i];
            }
        }
        System.out.println("Max volume= " + maxVal.toString());
    }

    public static void printDrinks() {
        for (int i = 0; i < drinks.length; i++) {
            System.out.println(drinks[i]);
        }
    }

}

class Drink {
    private float volume;

    public Drink() {

    }

    public Drink(float volume) {
        this.volume = volume;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "volume=" + volume + "L" +
                '}';
    }
}

class Whiskey extends Drink {
    public Whiskey(int volume) {
        setVolume((float) volume / 1000);
    }

    public int getVolumeMl() {
        return (int) getVolume() * 1000;
    }

    public void setVolume(int volume) {
        setVolume((float) volume / 1000);
    }

    @Override
    public String toString() {
        return "Whiskey{" + super.toString() +
                '}';
    }


}