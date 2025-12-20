package com.app;

import io.github.palexdev.materialfx.theming.JavaFXThemes;
import io.github.palexdev.materialfx.theming.MaterialFXStylesheets;
import io.github.palexdev.materialfx.theming.UserAgentBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Correct MaterialFX theme setup for v11.x
        UserAgentBuilder.builder()
                .themes(JavaFXThemes.MODENA)  // Keep JavaFX default base (recommended)
                .themes(MaterialFXStylesheets.forAssemble(true))  // MaterialFX default theme
                .setDeploy(true)
                .setResolveAssets(true)
                .build()
                .setGlobal();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
        Scene scene = new Scene(loader.load(), 800, 600);

        stage.setTitle("Modern JavaFX App with MaterialFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}