package com.app;

import java.util.Objects;

public final class UserSession {

    // single instance of logged-in user
    private static User currentUser;

    // private constructor to prevent instantiation
    private UserSession() {}

    /**
     * Set the currently logged-in user.
     * Overrides any previous user.
     */
    public static void setUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null when setting session.");
        }
        currentUser = user;
    }

    /**
     * Get the currently logged-in user.
     * @return User object or null if no user is logged in.
     */
    public static User getUser() {
        return currentUser;
    }

    /**
     * Clears the current session.
     * Call this on logout.
     */
    public static void clear() {
        currentUser = null;
    }

    /**
     * Checks if a user is currently logged in.
     */
    public static boolean isLoggedIn() {
        return currentUser != null;
    }
}
