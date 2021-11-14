package by.tms.repository;

import by.tms.repository.options.ConnectedBD;
import by.tms.repository.options.Constans;

import java.sql.*;

public class UserRepositoryCheck extends ConnectedBD {


    public static boolean checkForExistenceName(String username) {

            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "SELECT * FROM " + Constans.USER_TABLE + " WHERE BINARY " + Constans.USER_USERNAME + " = ?";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, username);
                    ResultSet rs = prep.executeQuery();
                    return rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

        return false;
    }

    public static boolean checkPassword(String username, String enteredPassword) {

            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {

                String query = "SELECT * FROM " + Constans.USER_TABLE + " WHERE " + Constans.USER_PASSWORD +" = ? AND " + Constans.USER_USERNAME + " = ?";

                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, enteredPassword);
                    prep.setString(2, username);
                    ResultSet rs = prep.executeQuery();
                    return rs.next();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        return false;
    }
}
