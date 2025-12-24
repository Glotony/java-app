package com.app;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MainController {

    @FXML
    private Label statusLabel;

    @FXML
    private MFXButton actionButton;

    @FXML
    private void handleButtonClick(ActionEvent event) throws IOException {
        statusLabel.setText("Status: Going to Login...");
        SceneManager.switchTo(event, "second.fxml");  // → Login page
    }
}