package by.tms.repository;

import by.tms.entity.User;
import by.tms.repository.options.ConnectedBD;
import by.tms.repository.options.Constans;
//import com.sun.org.apache.bcel.internal.Const;

import java.sql.*;


public class UserRepositoryFunction extends ConnectedBD {
//
//    private static final String url = "jdbc:mysql://localhost/user?useUnicode=true&serverTimezone=UTC";
//    private static final String login = "root";
//    private static final String password = "root";

    public static void saveUser(User user){

            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "INSERT INTO " + Constans.USER_TABLE + "(" + Constans.USER_NAME + ", "
                        + Constans.USER_USERNAME + ", "+ Constans.USER_PASSWORD + ")" + " values (?, ?, ?)";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, user.getName());
                    prep.setString(2, user.getUsername());
                    prep.setString(3, user.getPassword());
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

    }

    public static void changeName(int userId, String newName){

            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "UPDATE " + Constans.USER_TABLE + " SET " + Constans.USER_NAME + " = ? WHERE " + Constans.USER_ID + " = ?";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, newName);
                    prep.setInt(2, userId);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

    }

    public static void changePassword(int userId, String newPassword){

            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "UPDATE "+ Constans.USER_TABLE +" SET "+ Constans.USER_PASSWORD + " = ? WHERE " + Constans.USER_ID + " = ?";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, newPassword);
                    prep.setInt(2, userId);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

    }

    public static void deleteUser(int userId){

            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "DELETE FROM " + Constans.USER_TABLE + " WHERE "+ Constans.USER_ID +" = ?";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setInt(1, userId);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }

    }

    public static User getUser(String username) {

            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "SELECT * FROM "+ Constans.USER_TABLE + " WHERE " + Constans.USER_USERNAME + " = ?";
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

        return null;
    }


}
