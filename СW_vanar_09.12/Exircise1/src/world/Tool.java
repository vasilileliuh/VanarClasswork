package world;

public class Tool {
    private float weight;

    Tool() {
    }

    public Tool(float weight) {
        setWeight(weight);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        if (weight < 0.1 || weight > 10.0)
            System.err.println("Error");
        else
            this.weight = weight;
    }

    public String toString() {
        return "{" + weight + "kg}";
    }
}
