package data;

public class Cat implements FelineInterface{
    private String name;
    private String race;
    private int year;

    public Cat(String name, String race, int year) {
        this.name = name;
        this.race = race;
        this.year = year;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRace() {
        return race;
    }

    @Override
    public void setRace(String race) {
        this.race = race;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", year=" + year +
                '}';
    }

}
