package com.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class ThirdController {

    // This is now your MAIN DASHBOARD after login
    @FXML
    private void goToContact(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "fourth.fxml");
    }

    @FXML
    private void goToProfile(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "fifth.fxml");
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "second.fxml"); // Back to login
    }

    // Remove or comment out old methods:
    /*
    @FXML
    private void goBackToSecond(ActionEvent event) throws IOException {
        // No longer needed - second is login now
    }

    @FXML
    private void goToMain(ActionEvent event) throws IOException {
        // No longer needed - main is welcome
    }
    */
}