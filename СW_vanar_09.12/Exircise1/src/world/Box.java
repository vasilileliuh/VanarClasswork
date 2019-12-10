package world;

public class Box {

    private Tool tool;

    public Box(Tool tool) {
        setTool(tool);
    }

    public Tool getTool() {
        return tool;
    }

    private void setTool(Tool tool) {
        if (tool == null)
            System.err.println("Error no tool!");
        else
            this.tool = tool;
    }

    public String toString() {
        return "{In the Box: " + getTool() + "}";
    }

}

