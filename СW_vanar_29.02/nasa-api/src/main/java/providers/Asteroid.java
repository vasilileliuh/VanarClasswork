package providers;

import java.time.LocalDate;

public class Asteroid {
    private LocalDate date;
    private Float distance;
    private Float diameter;
    private Boolean hazardous;

    public LocalDate getDate() {
        return date;
    }

    public Asteroid(LocalDate date, Float distance, Float diameter, Boolean hazardous) {
        this.date = date;
        this.distance = distance;
        this.diameter = diameter;
        this.hazardous = hazardous;
    }


    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getDiameter() {
        return diameter;
    }

    public void setDiameter(Float diameter) {
        this.diameter = diameter;
    }

    public Boolean getHazardous() {
        return hazardous;
    }

    public void setHazardous(Boolean hazardous) {
        this.hazardous = hazardous;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "date=" + date +
                ", distance=" + distance +
                ", diameter=" + diameter +
                ", hazardous=" + hazardous +
                '}';
    }
}

//    Вывод должен вглядеть так:
//        2020/02/01 - 4.1mln km from earth, 0.02km diameter, it is hazardous!
//        И так для каждого астероида.
//        Рекомендация : создать класс Asteroid и потом из него колекцию астероидов
