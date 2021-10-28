package by.tms.repository;

import by.tms.entity.User;
import by.tms.repository.options.ConnectedBD;

import java.sql.*;


public class UserRepositoryFunction extends ConnectedBD {
//
//    private static final String url = "jdbc:mysql://localhost/user?useUnicode=true&serverTimezone=UTC";
//    private static final String login = "root";
//    private static final String password = "root";

    public static void addUser(User user){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query =  "INSERT INTO users (name, username, password) values (?, ?, ?)";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, user.getName());
                    prep.setString(2, user.getUsername());
                    prep.setString(3, user.getPassword());
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void changeName(int userId, String newName){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "UPDATE USERS SET name = ? WHERE id = ?";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, newName);
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

    public static void changePassword(int userId, String newPassword){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "UPDATE USERS SET password = ? WHERE id = ?";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, newPassword);
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

    public static void deleteUser(int userId){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "DELETE FROM USERS WHERE id = ?";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setInt(1, userId);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "SELECT * FROM user.users WHERE users.username = ?";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, username);
                    ResultSet rs = prep.executeQuery();
                    if(rs.next()){
                        return new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
                    }
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
