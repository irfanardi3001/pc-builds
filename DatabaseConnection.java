package com.simulation.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL="jdbc:mysql://localhost:3306/pc_build_simulation";
    private static final String USERNAME="root";
    private static final String PASSWORD="";

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        connection.setAutoCommit(false);
        return connection;
    }
}
