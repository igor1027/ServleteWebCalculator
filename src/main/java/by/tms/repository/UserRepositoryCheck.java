package by.tms.repository;

import by.tms.repository.options.ConnectedBD;

import java.sql.*;

public class UserRepositoryCheck extends ConnectedBD {


    public static boolean checkForExistenceName(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "SELECT * FROM USERS WHERE username = ?";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, username);
                    ResultSet rs = prep.executeQuery();
                    return rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkPassword(String username, String enteredPassword) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {

                String query = "SELECT * FROM USERS WHERE password = ? AND username = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, enteredPassword);
                    prep.setString(2, username);
                    ResultSet rs = prep.executeQuery();
                    return rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
