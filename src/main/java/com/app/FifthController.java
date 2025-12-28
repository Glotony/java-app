package com.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class FifthController {

    @FXML
    private Label usernameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label fullNameLabel;

    @FXML
    public void initialize() {
        User user = UserSession.getUser();

        if (user != null) {
            usernameLabel.setText("Username: " + user.getUsername());
            emailLabel.setText("Email: " + user.getEmail());
            fullNameLabel.setText("Full Name: " + user.getFullName());
        }
    }

    @FXML
    private void goBackToMain(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "third.fxml");
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        UserSession.clear();
        SceneManager.switchTo(event, "second.fxml");
    }
}
