package com.app;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class RegisterController {

    @FXML private MFXTextField usernameField;
    @FXML private MFXTextField fullNameField;
    @FXML private MFXTextField emailField;
    @FXML private MFXPasswordField passwordField;
    @FXML private MFXButton registerBtn;

    @FXML
    public void initialize() {
        registerBtn.setOnAction(e -> handleRegister());
    }

    private void handleRegister() {
        String username = usernameField.getText().trim();
        String fullName = fullNameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText();   // passwords usually not trimmed

        // Basic validation
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Registration Failed", 
                      "Username, password, and email are required!");
            return;
        }

        if (password.length() < 6) {
            showAlert(Alert.AlertType.ERROR, "Registration Failed", 
                      "Password must be at least 6 characters long!");
            return;
        }

        // Call the updated DBHelper (now only 3 parameters)
        boolean success = DBHelper.registerUser(username, password, email);

        if (success) {
            showAlert(Alert.AlertType.INFORMATION, "Success", 
                      "User registered successfully!");

            // Optional: Clear the fields after successful registration
            usernameField.clear();
            fullNameField.clear();
            emailField.clear();
            passwordField.clear();
        } else {
            showAlert(Alert.AlertType.ERROR, "Registration Failed", 
                      "Registration failed. Username may already exist.");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}