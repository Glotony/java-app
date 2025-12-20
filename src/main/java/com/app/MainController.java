package com.app;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private Label statusLabel;

    @FXML
    private MFXButton actionButton;

    @FXML
    private void handleButtonClick(ActionEvent event) throws Exception {
        // Load second page
        Parent root = FXMLLoader.load(getClass().getResource("/second.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();

        // Optional: remove the time text update if you don't want it
        // statusLabel.setText("...");
    }
}