package by.tms.repository;

import by.tms.repository.options.ConnectedBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CalculatorRepository extends ConnectedBD {

    public static void addOperation(int userId, String operation){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query =  "INSERT INTO operations (operation, user_id) values (?, ?)";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, operation);
                    prep.setInt(2, userId);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
