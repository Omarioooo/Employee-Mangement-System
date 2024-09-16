package srcCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

    // Declare components
    JLabel lblName, lblID, imageLbl, gifLbl;
    JTextField nameField;
    JPasswordField idField;
    JButton loginBtn, exitBtn;
    ImageIcon originalIcon, scaledIcon, originalEmp, scaledEmp, frameIcon;
    Image image, empImage;
    DBConnection connection;

    public Login() {
        connection = new DBConnection();
        // Create JFrame
        setTitle("Login: Employees System");
        frameIcon = new ImageIcon(ClassLoader.getSystemResource("icons/frameIcon.png"));
        setIconImage(frameIcon.getImage());
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);


        // Create the components
        // Create the Name label
        lblName = new JLabel("Employee :");
        lblName.setBounds(40, 30, 100, 30);
        add(lblName);

        // Create the ID label
        lblID = new JLabel("ID :");
        lblID.setBounds(83, 80, 100, 30);
        add(lblID);

        // Create the name field
        nameField = new JTextField();
        nameField.setBounds(120, 38, 160, 25);
        add(nameField);

        // Create the id field
        idField = new JPasswordField();
        idField.setBounds(120, 88, 160, 25);
        add(idField);

        // Create the login button
        loginBtn = new JButton("Login");
        loginBtn.setBounds(205, 150, 90, 25);
        loginBtn.setFocusPainted(false);
        loginBtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        loginBtn.addActionListener(new ButtonHandler());
        add(loginBtn);

        // Create the exit button
        exitBtn = new JButton("Exit");
        exitBtn.setBounds(110, 150, 90, 25);
        exitBtn.setFocusPainted(false);
        exitBtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        exitBtn.addActionListener(new ButtonHandler());
        add(exitBtn);

        // Set the background
        originalEmp = new ImageIcon(ClassLoader.getSystemResource("icons/emp.jpg"));
        empImage = originalEmp.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        scaledEmp = new ImageIcon(empImage);
        gifLbl = new JLabel(scaledEmp);
        gifLbl.setBounds(370, 10, 600, 400);
        add(gifLbl);

        originalIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        image = originalIcon.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        scaledIcon = new ImageIcon(image);
        imageLbl = new JLabel(scaledIcon);
        imageLbl.setBounds(0, 0, 600, 300);
        add(imageLbl);

        // Set the frame visible
        setVisible(true);
    }

    // A method to dispose the current frame
    void Dispose() {
        this.dispose();
    }

    // A method to extract the id from the id field
    int extractID() {
        // Get the password as a char array & Convert the char array to a String
        char[] passwordChars = idField.getPassword();
        String idAsString = new String(passwordChars);
        int id;
        try {
            id = Integer.parseInt(idAsString);
            return id;
        } catch (Exception e) {
            return -1;
        }
    }

    // A method to clear the fields when errors
    void clearFields() {
        nameField.setText("");
        idField.setText("");
    }

    // A method to determine the rule witch specifies the next dashboard
    String getRule(DBConnection dbConnection) throws SQLException {
        String query = "Select position from employees where id = ?";
        String rule = null;
        try (PreparedStatement stmt = dbConnection.getConnection().prepareStatement(query)) {
            stmt.setInt(1, extractID());
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    rule = resultSet.getString("position");
                }
            }
        }
        return rule;
    }

    // A method to get the next page
    void nextDashBoard(String rule, DBConnection connection) {
        switch (rule) {
            case "ADMIN":
                new AdminDashBoard(extractID(), connection);
                break;

            case "HR":
                new HrDashBoard(extractID(), connection);
                break;

            case "EMPLOYEE":
                new EmployeeDashBoard(extractID(), connection);
                break;
            default:
                JOptionPane.showMessageDialog(this, "There is no rule",
                        "Failed", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }


    // An inner class to handel the events
    private final class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == loginBtn) {
                LoginListener();
            } else if (e.getSource() == exitBtn) {
                System.exit(0);
            }
        }

        // A method checking if the logins succeed
        private void checkLogging(boolean login) {
            if (login) {
                Dispose();
            } else {
                JOptionPane.showMessageDialog(loginBtn, "Please check your data",
                        "Login Failed", JOptionPane.ERROR_MESSAGE);
                clearFields();
            }
        }


        // A method to handel the login button
        private void LoginListener() {
            // A flag to check if the employee exists
            boolean login;

            // The data put from the user
            int id = extractID();
            String name = nameField.getText();

            connection.Connect();
            try {
                login = connection.logInCheck(name, id);
                // System.out.println("LogIN is " + login);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(loginBtn, ex.getMessage(),
                        "Connection Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }
            checkLogging(login);
            String rule = null;
            try {
                rule = getRule(connection);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(loginBtn, e.getMessage(),
                        "Connection Failed", JOptionPane.ERROR_MESSAGE);
            }
            nextDashBoard(rule, connection);
        }
    }
}
