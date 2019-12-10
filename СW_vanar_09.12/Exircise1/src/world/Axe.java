package world;

public class Axe extends Tool {

    public Axe(float weight) {
        setWeight(weight);
    }

    public String toString() {
        return "{This is an Axe " + super.toString() + "}";
    }
}
