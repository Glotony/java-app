package com.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class FifthController {

    @FXML
    private void goBackToMain(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "third.fxml"); // Back to dashboard
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "second.fxml"); // Back to login
    }
}