package space;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Asteroid {
    private LocalDate date;
    private Float distance;
    private Float diameter;
    private Boolean isHazardous;

    public Asteroid(LocalDate date, Float distance, Float diameter, Boolean isHazardous) {
        this.date = date;
        this.distance = distance;
        this.diameter = diameter;
        this.isHazardous = isHazardous;
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

    public Boolean getIsHazardous() {
        return isHazardous;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    @Override
    public String toString() {
        return "Asteroid{" +
                "date=" + date +
                ", distance=" + distance +
                ", diameter=" + diameter +
                ", hazardous=" + isHazardous +
                '}';
    }
}
