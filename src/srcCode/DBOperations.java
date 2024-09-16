package srcCode;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBOperations {

    private DBConnection connection;

    public DBOperations(DBConnection connection) {
        this.connection = connection;
    }

    // How each position sees the employee of the same position
    public ResultSet SelectRule(int id, String position) throws SQLException {
        ResultSet resultSet;
        String query = "EXEC RULES @login_id = ?, @rule = ?";
        CallableStatement stmt = connection.getConnection().prepareCall(query);
        stmt.setInt(1, id);
        stmt.setString(2, position);
        resultSet = stmt.executeQuery();

        return resultSet;
    }

    // How Hrs and Employees see the info of the admins
    public ResultSet getAdmin() throws SQLException {
        ResultSet resultSet;
        String query = "EXEC EmpsWithoutSalary ? ";
        CallableStatement stmt = connection.getConnection().prepareCall(query);
        stmt.setString(1, "Admin");
        resultSet = stmt.executeQuery();

        return resultSet;
    }

    // How Employees see the info of the Hrs
    public ResultSet empGetHR() throws SQLException {
        ResultSet resultSet;
        String query = "EXEC EmpsWithoutSalary ? ";
        CallableStatement stmt = connection.getConnection().prepareCall(query);
        stmt.setString(1, "HR");
        resultSet = stmt.executeQuery();

        return resultSet;
    }

    // How Admins see the info of the Hrs
    public ResultSet adminGetHR() throws SQLException {
        ResultSet resultSet;
        String query = "EXEC EmpsWithSalary ? ";
        CallableStatement stmt = connection.getConnection().prepareCall(query);
        stmt.setString(1, "HR");
        resultSet = stmt.executeQuery();

        return resultSet;
    }

    // How Hrs and admins see the info of the employees
    public ResultSet getEmployee() throws SQLException {
        ResultSet resultSet;
        String query = "EXEC EmpsWithSalary ? ";
        CallableStatement stmt = connection.getConnection().prepareCall(query);
        stmt.setString(1, "employee");
        resultSet = stmt.executeQuery();

        return resultSet;
    }


    public void Add(String fname, String lname, String address,
                    String phone, String email, String Position, double salary) throws SQLException {
        String query = "INSERT INTO employees VALUES (?,?,?,?,?,?,?)";

        PreparedStatement stmt = connection.getConnection().prepareStatement(query);
        stmt.setString(1, fname);
        stmt.setString(2, lname);
        stmt.setString(3, address);
        stmt.setString(4, phone);
        stmt.setString(5, email);
        stmt.setString(6, Position);
        stmt.setDouble(7, salary);

        stmt.executeUpdate();

        // Close the statement
        stmt.close();
    }

    public void Delete(int id, String fname, String lname) throws SQLException {
        String query = "DELETE FROM employees WHERE id = ? AND firstName = ? AND lastName = ?";

        PreparedStatement stmt = connection.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        stmt.setString(2, fname);
        stmt.setString(3, lname);

        stmt.executeUpdate();

        // Close the statement
        stmt.close();
    }

    public void Update(String address, String phone, String email, String position, double salary, int id) throws SQLException {
        String updateQuery = "UPDATE employees SET address = ?, phone = ?, email = ?, position = ?, salary = ? WHERE id = ?";
        PreparedStatement stmt = connection.getConnection().prepareStatement(updateQuery);
        stmt.setString(1, address);
        stmt.setString(2, phone);
        stmt.setString(3, email);
        stmt.setString(4, position);
        stmt.setDouble(5, salary);
        stmt.setInt(6, id);

        stmt.executeUpdate();
    }


    // For the admin to update emp info
    public ResultSet Search(int id) throws SQLException {
        ResultSet resultSet = null;
        String query = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement stmt = connection.getConnection().prepareStatement(query);
        stmt.setInt(1, id);
        resultSet = stmt.executeQuery();

        return resultSet;
    }


}
