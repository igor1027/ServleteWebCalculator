package by.tms.repository.options;

import by.tms.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectedBD {

    protected static final String url = "jdbc:mysql://localhost/user?useUnicode=true&serverTimezone=UTC";
    protected static final String login = "root";
    protected static final String passwordBD = "root";
}
