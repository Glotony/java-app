package com.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class ThirdController {

    // MAIN DASHBOARD after login

    @FXML
    private void goToContact(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "fourth.fxml");
    }

    @FXML
    private void goToProfile(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "fifth.fxml");
    }


    @FXML
    private void goToProducts(ActionEvent event) throws IOException {
        // optional, if you later want Products button to work
        SceneManager.switchTo(event, "products.fxml");
    }

    @FXML
    private void handleLogout(ActionEvent event) throws IOException {
        SceneManager.switchTo(event, "second.fxml");
    }

}
