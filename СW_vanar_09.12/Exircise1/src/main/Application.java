package main;

import world.Axe;
import world.Box;
import world.Hammer;
import world.Tool;

public class Application {
    public static void main(String[] args) {

        Box boxBig = new Box(new Hammer(2.5f));
        System.out.println(boxBig.toString());
        Box boxBig2 = new Box(new Axe(2.35f));
        System.out.println(boxBig2.toString());
        Box boxBig3 = new Box(new Tool(8.95f));
        System.out.println(boxBig3.toString());

        System.out.println(boxBig2.getTool().getWeight());

        boxBig.getTool().setWeight(0.10f);

        Box boxEmpty = new Box(new Hammer(0.1f));
        Box boxEmpty2 = new Box(new Hammer(0.1f));
        setHammerWeight(boxEmpty2, 9.9f);
        setHammerWeight(boxEmpty, 9.1f);

    }

    private static void setHammerWeight(Box box, float weight) {
        if (box.getTool() == null)
            System.err.println("Error, there is no Tool!");
        else
            box.getTool().setWeight(weight);

    }
}
