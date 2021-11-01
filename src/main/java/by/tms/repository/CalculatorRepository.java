package by.tms.repository;

import by.tms.entity.User;
import by.tms.repository.options.ConnectedBD;
import by.tms.repository.options.Constans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorRepository extends ConnectedBD {

    public static void saveOperation(String num1, String operation, String num2, String result, int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query =  "INSERT INTO " + Constans.OPERATION_TABLE + " ( " + Constans.OPERATION_NUM1 + ", "
                        + Constans.OPERATION_OPERATIONS + ", " + Constans.OPERATION_NUM2 + ", " + Constans.OPERATION_RESULT + ", " + Constans.OPERATION_USER_ID + " ) values (?, ?, ? , ?, ?)";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setString(1, num1);
                    prep.setString(2, operation);
                    prep.setString(3, num2);
                    prep.setString(4,result);
                    prep.setInt(5, id);
                    prep.execute();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static List<String> getOperation (int id){
        List<String> operationList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = DriverManager.getConnection(url, login, passwordBD)) {
                String query = "SELECT " + Constans.OPERATION_RESULT + " FROM "+ Constans.OPERATION_TABLE + " WHERE " + Constans.OPERATION_USER_ID + " = ?";
                try (PreparedStatement prep = connection.prepareStatement(query)) {
                    prep.setInt(1, id);
                    ResultSet rs = prep.executeQuery();
                    while (rs.next()){
                        operationList.add(rs.getString(1));
                    }
                    return operationList;
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
