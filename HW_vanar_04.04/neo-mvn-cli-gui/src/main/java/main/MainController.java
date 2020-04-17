package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import space.Asteroid;
import space.NASADataProvider;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainController {
    @FXML
    public TextArea textArea;
    @FXML
    private TextField startDateInput;
    @FXML
    private TextField endDateInput;

    @FXML
    private Button mainButton;

    @FXML
    private void getData() {
        List<Asteroid> asteroids = null;
        try {
            asteroids = new NASADataProvider().getNeoAsteroids(startDateInput.getText(), endDateInput.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        for (Asteroid asteroid : asteroids) {
            textArea.appendText(asteroid.getDate().format(formatter) +
                    " - " + (String.valueOf(Math.abs(Math.round(asteroid.getDistance() / 1_000_00f) / 10f)).length() < 4 ?
                    "  " + Math.round(asteroid.getDistance() / 1_000_00f) / 10f + "mln km from earth, " :
                    Math.round(asteroid.getDistance() / 1_000_00f) / 10f + "mln km from earth, ") +
                    " " + (String.valueOf(Math.abs(Math.round(asteroid.getDiameter() * 100f) / 100f)).length() < 4 ?
                    "  " + Math.round(asteroid.getDiameter() * 100f) / 100f + "km diameter, " :
                    Math.round(asteroid.getDiameter() * 100f) / 100f + "km diameter, ") +
                    " " + (asteroid.getHazardous() ? "it is hazardous!" : "it's not hazardous!") + "\n");
        }

    }

}

