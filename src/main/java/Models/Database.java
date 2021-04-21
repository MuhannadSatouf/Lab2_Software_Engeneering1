package Models;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Database {
    public static String url = "jdbc:mysql://ro03.beginit.se:23306/project01?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC";
    public static String username = "stud";
    public static String password = "studentRemote!";

    private static Database myDBConnection;
    public static Connection dbConnection;
    private Statement statement;
    private ResultSet resultSet;

    public Database() {

    }

    public static Database getInstance() {
        if (myDBConnection == null) {
            myDBConnection = new Database();
            try {
                dbConnection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection to DB established");
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Failed to connect to DB");
                alert.showAndWait();
                e.getSuppressed();
            }
        }

        return myDBConnection;
    }

    public static Connection getConnection() {

        return dbConnection;
    }

    public void disconnect() {

        try {
            System.out.println("Disconnected from DB");
            if (dbConnection != null)
                dbConnection.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException ex) {
            System.out.println("Failed to disconnect from DB!");
        }
    }
}


