package Models;

import javafx.scene.control.Alert;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Database {
    private static final String url = "jdbc:mysql://ro03.beginit.se:23306/project01?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC";
    private static final String username = "stud";
    private static final String password = "studentRemote!";
    public static Connection dbConnection;
    private static Database myDBConnection;
    private static boolean connected;
    private Statement statement;
    private ResultSet resultSet;

    public static Database getInstance() {
        if (myDBConnection == null) {
            myDBConnection = new Database();
            try {
                dbConnection = DriverManager.getConnection(url, username, password);
                System.out.println("Connection to DB established");
                connected = true;
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Failed to connect to DB");
                alert.showAndWait();
                e.getSuppressed();
                connected = false;
                return null;
            }
        }

        return myDBConnection;
    }

    public static Connection getConnection() {

        return dbConnection;
    }

    public boolean isConnected() {

        return connected;
    }

    public void disconnect() {

        try {
            System.out.println("Disconnected from DB");
            if (dbConnection != null)
                dbConnection.close();
            connected = false;
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException ex) {
            System.out.println("Failed to disconnect from DB!");
        }
    }
}


