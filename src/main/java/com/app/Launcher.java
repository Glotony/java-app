package com.app;

/**
 * Launcher class for non-modular JavaFX applications bundled with jpackage.
 * This bypasses the module system check that causes JavaFX to fail in shaded/non-modular bundles.
 */
public class Launcher {

    public static void main(String[] args) {
        // Simply delegate to your original App class
        App.main(args);
    }
}