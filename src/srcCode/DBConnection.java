package srcCode;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

    private boolean flgCon;
    private Connection connection;

    public DBConnection() {
    }

    // Read the server data using I/O Streams
    public SQLServerDataSource myDriver() {
        SQLServerDataSource sqlServerDataSource = new SQLServerDataSource();
        Properties properties = new Properties();
        FileInputStream Info;
        try {
            Info = new FileInputStream("D:\\SQL_SERVER.txt");
            properties.load(Info);
            sqlServerDataSource.setURL(properties.getProperty("URL"));
            sqlServerDataSource.setUser(properties.getProperty("USER"));
            sqlServerDataSource.setPassword(properties.getProperty("PASSWORD"));
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

        return sqlServerDataSource;
    }

    // A method to connect the server
    public void Connect() {
        try {
            connection = myDriver().getConnection();
            flgCon = true;
        } catch (SQLServerException sql) {
            sql.printStackTrace();
            System.out.println("Connection failed...");
            flgCon = false;
        }
    }

    // A getter for the connection
    public Connection getConnection(){
        return this.connection;
    }

    // Stop the connection
    public void disConnect() {
        try {
            connection.close();
            flgCon = false;
            System.out.println("Disconnected...");
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
    }

    // A method to check the connection
    public boolean isConnect() {
        return flgCon;
    }

    // A method to check the login info
    public boolean logInCheck(String name, int id) throws SQLException {
        String queryForCheck = "SELECT * FROM employees WHERE id = ? AND firstName+' '+lastName = ?";

        try (PreparedStatement stmt = connection.prepareStatement(queryForCheck)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();  // Returns true if a row is found, false otherwise
            }

        } catch (SQLException e) {
            e.getStackTrace();
            return false;
        }
    }

}

