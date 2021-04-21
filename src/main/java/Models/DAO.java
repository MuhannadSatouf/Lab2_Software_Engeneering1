package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    private ResultSet resultSet = null;
    private User user;
    private String sSN;
    private String name;
    private String password;
    private int account_number;



    private User retrieveUser(String query, String sSN) {
        user = null;
        try {
            if (!Database.dbConnection.isClosed()) {
                resultSet = retrieveSet(query, sSN);
                if (resultSet != null) {
                    if (resultSet.first()) {
                        return user = createObjects(resultSet);
                    }
                } else {
                    System.out.println("Empty resultSet");
                    return user;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error while working with ResultSet!");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return user;
        }
    }
    public User getUser(String sSN) {
        User temp = null;
        String query = "SELECT * FROM User where ssn = ?;";
        try {
            temp = retrieveUser(query, sSN);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    private User createObjects(ResultSet resultSet) throws Exception {
        sSN = resultSet.getString("person_number");
        name = resultSet.getString("name");
        account_number = resultSet.getInt("account_number");
        password = resultSet.getString("password");
        user = new User(sSN, name, account_number);
        user.setPassword(password);
        return user;
    }

    protected ResultSet retrieveSet(String queryString, String... params) {
        try {
            if (!Database.dbConnection.isClosed()) {
                PreparedStatement prepStmt = Database.getConnection().prepareStatement(queryString);
                for (int i = 0; i < params.length; i++) {
                    prepStmt.setString(i+1, params[i]);
                }
                return resultSet = prepStmt.executeQuery();
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println("Error when executing statement!");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return resultSet;
    }
}
