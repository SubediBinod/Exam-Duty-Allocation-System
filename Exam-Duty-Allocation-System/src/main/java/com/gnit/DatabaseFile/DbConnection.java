package com.gnit.DatabaseFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection{

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/faculty_management";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ClassNotFoundException("JDBC Driver not found", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error establishing database connection", e);
        }
        return conn;
    }
}
