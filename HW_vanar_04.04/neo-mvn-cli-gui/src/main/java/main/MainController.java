package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import space.Asteroid;
import space.NASADataProvider;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

public class MainController {
    @FXML
    public TableView<Asteroid> tableView;
    public TableColumn date;
    public TableColumn diameter;
    public TableColumn distance;
    public TableColumn hazardous;
    @FXML
    private TextField startDateInput;
    @FXML
    private TextField endDateInput;
    @FXML
    private Button mainButton;
    @FXML
    private Button logInButton;

    @FXML
    private void getData() {
        List<Asteroid> asteroids = null;
        try {
            if (isValidDate(startDateInput.getText()) && isValidDate(endDateInput.getText())) {
                asteroids = new NASADataProvider().getNeoAsteroids(startDateInput.getText(), endDateInput.getText());
                startDateInput.setText("");
                endDateInput.setText("");
                startDateInput.setPromptText("start date : YYYY-MM-DD");
                endDateInput.setPromptText("end date : YYYY-MM-DD");
            } else if (!isValidDate(startDateInput.getText()) && !isValidDate(endDateInput.getText())) {
                startDateInput.setText("");
                endDateInput.setText("");
                startDateInput.setPromptText("e.g. 2000-12-31");
                endDateInput.setPromptText("e.g. 2000-12-31");
////                listView.getItems().clear();
////                listView.getItems().add("An error has occurred.\nPlease enter both dates in the following format: YYYY-MM-DD.");
            } else if (!isValidDate(startDateInput.getText())) {
////                listView.getItems().clear();
////                listView.getItems().add("The start date is invalid.\n Please enter a date in the format: YYYY-MM-DD.");
                startDateInput.setText("");
                startDateInput.setPromptText("e.g. 2000-12-31");
            } else if (!isValidDate(endDateInput.getText())) {
////                listView.getItems().clear();
////                listView.getItems().add("The end date is invalid.\nPlease enter the date in the following format: YYYY-MM-DD.");
                endDateInput.setText("");
                endDateInput.setPromptText("e.g. 2000-12-31");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        final ObservableList<Asteroid> data = FXCollections.observableArrayList(asteroids);
        date.setCellValueFactory(new PropertyValueFactory<Asteroid, LocalDate>("date"));
        distance.setCellValueFactory(new PropertyValueFactory<Asteroid, Float>("distance"));
        diameter.setCellValueFactory(new PropertyValueFactory<Asteroid, Float>("diameter"));
        hazardous.setCellValueFactory(new PropertyValueFactory<Asteroid, Boolean>("isHazardous"));
        tableView.setItems(data);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//        if (asteroids != null) {
//            listView.getItems().clear();
//            for (Asteroid asteroid : asteroids) {
//                /* textArea.appendText() */
//                listView.getItems().add(asteroid.getDate().format(formatter) +
//                        " - " + (String.valueOf(Math.abs(Math.round(asteroid.getDistance() / 1_000_00f) / 10f)).length() < 4 ?
//                        "  " + Math.round(asteroid.getDistance() / 1_000_00f) / 10f + "mln km from earth, " :
//                        Math.round(asteroid.getDistance() / 1_000_00f) / 10f + "mln km from earth, ") +
//                        " " + (String.valueOf(Math.abs(Math.round(asteroid.getDiameter() * 100f) / 100f)).length() < 4 ?
//                        "  " + Math.round(asteroid.getDiameter() * 100f) / 100f + "km diameter, " :
//                        Math.round(asteroid.getDiameter() * 100f) / 100f + "km diameter, ") +
//                        " " + (asteroid.getHazardous() ? "it is hazardous!" : "it's not hazardous!") + "\n");
//            }
//        }
    }

    private boolean isValidDate(String dateInput) {
        return (dateInput.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})"));
    }

    @FXML
    private void getSecondWindow() throws IOException {
        GUIApplication.setRoot("/main");
    }

}

