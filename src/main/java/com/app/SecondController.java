package com.app;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.io.IOException;

public class SecondController {

    @FXML
    private MFXTextField usernameField;

    @FXML
    private MFXPasswordField passwordField;

    @FXML
    private MFXButton loginButton;

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        // Simple mock login
        if ("admin".equals(username) && "123".equals(password)) {
            // Login success → go to main dashboard (third.fxml)
            SceneManager.switchTo(event, "third.fxml");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Wrong username or password!\nTry: admin / 123");
            alert.showAndWait();
        }
    }

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "main.fxml");
    }
}