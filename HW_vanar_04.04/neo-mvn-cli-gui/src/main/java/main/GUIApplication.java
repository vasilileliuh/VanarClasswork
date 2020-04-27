package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUIApplication extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader loader = new FXMLLoader();
//        URL xmlUrl = getClass().getResource("/first.fxml");
//        loader.setLocation(xmlUrl);
//        Parent root = loader.load();
//        stage.setScene(new Scene(root));
//        stage.show();
        scene = new Scene(loadFXML("/first"));
        stage.setScene(scene);
        stage.setTitle("NASA NEO data");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
        scene.windowProperty().getValue().sizeToScene();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GUIApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
