package com.app;

import java.sql.*;

public class DBHelper {

    private static final String URL =
            "jdbc:mysql://localhost:3306/javafx_app?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "password";

    // LOGIN
    public static User getUser(String username, String password) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(
                     "SELECT * FROM users WHERE username=? AND password=?")) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getString("username"),
                        rs.getString("full_name"),
                        rs.getString("email")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // REGISTRATION
    public static boolean registerUser(String username, String password, String fullName, String email) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            // Check if username exists
            try (PreparedStatement checkStmt = conn.prepareStatement(
                    "SELECT * FROM users WHERE username=?")) {
                checkStmt.setString(1, username);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next()) {
                    System.out.println("Username already exists!");
                    return false;
                }
            }

            // Insert new user
            try (PreparedStatement insertStmt = conn.prepareStatement(
                    "INSERT INTO users (username, password, full_name, email) VALUES (?, ?, ?, ?)")) {
                insertStmt.setString(1, username);
                insertStmt.setString(2, password); // plain text for now
                insertStmt.setString(3, fullName);
                insertStmt.setString(4, email);

                int rowsInserted = insertStmt.executeUpdate();
                return rowsInserted > 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
