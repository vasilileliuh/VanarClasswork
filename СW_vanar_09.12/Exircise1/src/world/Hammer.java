package world;

public class Hammer extends Tool {

    public Hammer(float weight) {
        setWeight(weight);
    }

    public String toString() {
        return "{This is a Hammer " + super.toString() + "}";
    }
}
