package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private final String username = "stud";
    private final String password = "studentRemote!";


    public void connect() {
        System.out.println("MySQL connect example.");
        Connection conn = null;
        String url = "jdbc:mysql://ro03.beginit.se/";
        String dbname = "project01";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbname, username, password);
            System.out.println("Connected to the database");
            conn.close();
            System.out.println("Disconnected from database");
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}


