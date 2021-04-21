package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
    private ResultSet resultSet = null;
    private User user;
    private Account account;
    private double account_balance;



    private User retrieveUser(String query, String sSN) {
        user = null;
        try {
            if (!Database.dbConnection.isClosed()) {
                resultSet = retrieveSet(query, sSN);
                if (resultSet != null) {
                    if (resultSet.first()) {
                        return user = createUserObject(resultSet);
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

    private User createUserObject(ResultSet resultSet) throws Exception {
        String sSN = resultSet.getString("person_number");
        String name = resultSet.getString("name");
        int account_number = resultSet.getInt("account_number");
        String password = resultSet.getString("password");
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

    public Account getAccount() {
        Account temp = null;
        String query = "SELECT * FROM Account where id = 1;";
        try {
            temp = retrieveAccount(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return temp;
    }

    private Account retrieveAccount(String query) {
        account = null;
        try {
            if (!Database.dbConnection.isClosed()) {
                resultSet = retrieveSet(query);
                if (resultSet != null) {
                    if (resultSet.first()) {
                        return account = createAccountObject(resultSet);
                    }
                } else {
                    System.out.println("Empty resultSet");
                    return account;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error while working with ResultSet!");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                assert resultSet != null;
                resultSet.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return account;
        }
    }

    private Account createAccountObject(ResultSet resultSet) throws Exception {
        account_balance = resultSet.getDouble("account_balance");
        account.setAccount_balance(account_balance);
        return account;
    }

    private void updateBalance(Account account) {
        try {
            if (!Database.dbConnection.isClosed()) {
                if (account != null) {
                    account_balance = account.getAccount_balance();
                    String query = "UPDATE `Account` SET `account_balance` = ? WHERE (`id` = 1);";
                    PreparedStatement prepStmt = Database.getConnection().prepareStatement(query);

                    prepStmt.setDouble(1, account_balance);
                    prepStmt.executeUpdate();
                    prepStmt.close();

                } else {
                    throw new NullPointerException("The user object is null");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error while working with statement!");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setTransaction(Transaction transaction) {
        try {
            if (!Database.dbConnection.isClosed()) {
                if (transaction.getAmount() != 0) {
                    String queryString = "INSERT INTO `Transaction` (`id`, `amount`) VALUES (?, ?);";
                    PreparedStatement prepStmt = Database.getConnection().prepareStatement(queryString);
                    prepStmt.setDouble(2, transaction.getAmount());
                    prepStmt.executeUpdate();
                    prepStmt.close();
                    updateBalance(transaction.getAccount());   // pay attention to this method call - make sure not to call it twice
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error while working with statement!");
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
