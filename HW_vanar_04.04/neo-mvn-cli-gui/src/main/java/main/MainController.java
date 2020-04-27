package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import space.Asteroid;
import space.NASADataProvider;

import java.io.IOException;
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
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    Label error;

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
            } else if (!isValidDate(startDateInput.getText())) {
                startDateInput.setText("");
                startDateInput.setPromptText("e.g. 2000-12-31");
            } else if (!isValidDate(endDateInput.getText())) {
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
    }

    private boolean isValidDate(String dateInput) {
        return (dateInput.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})"));
    }

    @FXML
    private void getSecondWindow() throws IOException {
        if (user.getText().equals("user") && password.getText().equals("password"))
            GUIApplication.setRoot("/main");
        else
            error.setText("Wrong username or password!");
    }

}

