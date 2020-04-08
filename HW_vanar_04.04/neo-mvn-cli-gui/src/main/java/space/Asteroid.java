package space;

import java.time.LocalDate;

public class Asteroid {
    private LocalDate date;
    private Float distance;
    private Float diameter;
    private Boolean hazardous;

    public Asteroid(LocalDate date, Float distance, Float diameter, Boolean hazardous) {
        this.date = date;
        this.distance = distance;
        this.diameter = diameter;
        this.hazardous = hazardous;
    }

    public LocalDate getDate() {
        return date;
    }

    public Float getDistance() {
        return distance;
    }

    public Float getDiameter() {
        return diameter;
    }

    public Boolean getHazardous() {
        return hazardous;
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
