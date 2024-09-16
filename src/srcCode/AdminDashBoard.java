package srcCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDashBoard extends JFrame implements DashBoards {

    private final JLabel header, backGroundLabel;
    private final ImageIcon frameIcon, originalBackGround, scaledBackGround;
    private final Image imageBackGround;
    private final JButton addEmp, delEmp, updEmp, adminsbtn, hrsbtn, employeesbtn;
    private final DBConnection connection;
    private final int id;

    public AdminDashBoard(int id, DBConnection connection) {
        this.connection = connection;
        this.id = id;
        // Set up JFrame properties
        setTitle("DashBoard");
        setSize(800, 450);
        frameIcon = new ImageIcon(ClassLoader.getSystemResource("icons/frameIcon.png"));
        setIconImage(frameIcon.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Use null layout to set bounds manually

        // Set background
        originalBackGround = new ImageIcon(ClassLoader.getSystemResource("icons/dboard.jpg"));
        imageBackGround = originalBackGround.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
        scaledBackGround = new ImageIcon(imageBackGround);
        backGroundLabel = new JLabel(scaledBackGround);
        backGroundLabel.setBounds(0, 0, getWidth(), getHeight());
        add(backGroundLabel);

        // Create and configure the header label
        header = new JLabel("Admin DashBoard", SwingConstants.CENTER);
        header.setFont(new Font("Comic Sans MS", Font.ITALIC, 25));
        header.setBounds(0, 0, getWidth(), 50);
        header.setOpaque(true); // Make the gray background visible
        header.setBackground(Color.LIGHT_GRAY);
        backGroundLabel.add(header);  // Add header to the background label

        // Create add button
        addEmp = new JButton("Add Employee");
        addEmp.setBounds(55, 105, 200, 80);
        addEmp.setFocusPainted(false);
        addEmp.setBackground(new Color(0, 255, 0));
        addEmp.setFont(new Font("Comic Sans MS", Font.ITALIC, 17));
        addEmp.addActionListener(new Controller());
        backGroundLabel.add(addEmp);  // Add button to the background label

        // Create delete button
        delEmp = new JButton("Remove Employee");
        delEmp.setBounds(520, 105, 200, 80);
        delEmp.setFocusPainted(false);
        delEmp.setBackground(new Color(0, 255, 255));
        delEmp.setFont(new Font("Comic Sans MS", Font.ITALIC, 17));
        delEmp.addActionListener(new Controller());
        backGroundLabel.add(delEmp);  // Add button to the background label

        // Create update button
        updEmp = new JButton("Update Employee");
        updEmp.setBounds(288, 105, 200, 80);
        updEmp.setFocusPainted(false);
        updEmp.setBackground(new Color(255, 255, 0));
        updEmp.setFont(new Font("Comic Sans MS", Font.ITALIC, 17));
        updEmp.addActionListener(new Controller());
        backGroundLabel.add(updEmp);  // Add button to the background label

        // Create Admins button
        adminsbtn = new JButton("Admins ");
        adminsbtn.setBounds(55, 225, 200, 80);
        adminsbtn.setFocusPainted(false);
        adminsbtn.setBackground(new Color(255, 102, 178));
        adminsbtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        adminsbtn.addActionListener(new Controller());
        backGroundLabel.add(adminsbtn);  // Add button to the background label

        // Create Hrs button
        hrsbtn = new JButton("HRs");
        hrsbtn.setBounds(288, 225, 200, 80);
        hrsbtn.setFocusPainted(false);
        hrsbtn.setBackground(new Color(102, 178, 255, 255));
        hrsbtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        hrsbtn.addActionListener(new Controller());
        backGroundLabel.add(hrsbtn);  // Add button to the background label


        // Create employee button
        employeesbtn = new JButton("Employees");
        employeesbtn.setBounds(520, 225, 200, 80);
        employeesbtn.setFocusPainted(false);
        employeesbtn.setBackground(new Color(255, 153, 51));
        employeesbtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        employeesbtn.addActionListener(new Controller());
        backGroundLabel.add(employeesbtn);  // Add button to the background label


        // Set the frame visible
        setVisible(true);
    }

    // A method to dispose this Frame
    @Override
    public void Dispose() {
        this.dispose();
    }

    // A method to let the admin see all info about Admins except them salary
    @Override
    public void adminView() {
        ResultSet resultSet = null;
        DBOperations dbOperations = new DBOperations(connection);
        try {
            resultSet = dbOperations.SelectRule(id, "Admin");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Failed", JOptionPane.ERROR_MESSAGE);
        }
        new View(resultSet, connection, id, "admin");

    }

    // A method to let the admin see all info about HRs
    @Override
    public void hrView() {
        ResultSet resultSet = null;
        DBOperations dbOperations = new DBOperations(connection);
        try {
            resultSet = dbOperations.adminGetHR();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Failed", JOptionPane.ERROR_MESSAGE);
        }
        new View(resultSet, connection, id, "admin");

    }

    // A method to let the admin see all info about the Employees
    @Override
    public void empView() {
        ResultSet resultSet = null;
        DBOperations dbOperations = new DBOperations(connection);
        try {
            resultSet = dbOperations.getEmployee();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Failed", JOptionPane.ERROR_MESSAGE);
        }
        new View(resultSet, connection, id, "admin");

    }


    // An inner class to control the button actions
    private class Controller implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addEmp) {
                Dispose();
                new AddEmployee(connection, id, "admin");

            } else if (e.getSource() == updEmp) {
                Dispose();
                new UpdateEmployee(connection, id);

            } else if (e.getSource() == delEmp) {
                Dispose();
                new DeleteEmployee(id, connection);

            } else if (e.getSource() == adminsbtn) {
                Dispose();
                adminView();

            } else if (e.getSource() == hrsbtn) {
                Dispose();
                hrView();

            } else if (e.getSource() == employeesbtn) {
                Dispose();
                empView();
            }
        }
    }


}
