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
    @FXML private MFXPasswordField passwordField; // <-- MaterialFX type
    @FXML private MFXButton registerBtn;

    @FXML
    public void initialize() {
        registerBtn.setOnAction(e -> {
            String username = usernameField.getText().trim();
            String password = passwordField.getText();
            String fullName = fullNameField.getText().trim();
            String email = emailField.getText().trim();

            boolean success = DBHelper.registerUser(username, password, fullName, email);

            Alert alert = new Alert(success ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
            alert.setTitle("Registration");
            alert.setHeaderText(null);
            alert.setContentText(success ? "User registered successfully!" : "Registration failed or username exists!");
            alert.showAndWait();
        });
    }
}
