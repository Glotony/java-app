package com.app;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class SecondController {

    @FXML private MFXTextField usernameField;
    @FXML private MFXPasswordField passwordField;
    @FXML private MFXButton loginButton;
    @FXML private MFXButton registerButton;

    /**
     * Handles user login
     */
    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        // get user from DB
        User user = DBHelper.getUser(username, password); // must return User object, not null

        if (user != null) {
            // ✅ set session
            UserSession.setUser(user);

            // ✅ go to dashboard
            SceneManager.switchTo(event, "third.fxml");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Wrong username or password!");
            alert.showAndWait();
        }
    }

    /**
     * Opens the registration page in a new window
     */
    @FXML
    private void handleRegister(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/registration.fxml"));
            Scene scene = new Scene(loader.load(), 400, 500); // size as needed
            Stage stage = new Stage();
            stage.setTitle("Register New User");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to open registration page.");
            alert.showAndWait();
        }
    }

    /**
     * Go back to main/welcome page
     */
    @FXML
    private void goBack(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "main.fxml");
    }
}
