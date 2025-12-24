package com.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;

    public static void switchTo(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(SceneManager.class.getResource("/" + fxmlFile));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
}