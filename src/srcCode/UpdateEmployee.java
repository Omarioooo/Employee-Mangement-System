package srcCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateEmployee extends JFrame {
    private final ImageIcon frameIcon, originalBackGround, scaledBackGround;
    private final Image imageBackGround;
    private JLabel backGroundLabel, header, idlbl, fnamelbl, lnamelbl,
            addresslbl, phonelbl, emaillbl, posistionlbl, salarylbl;
    private final JTextField idField, fnameField, lnameField, phoneField, emailField,
            salaryField, addressField, searchField;
    private final JComboBox<String> positionComboBox;
    private final JButton updatebtn, exitbtn, backbtn, searchBtn;
    private final DBConnection connection;
    private final int id;

    public UpdateEmployee(DBConnection connection, int id) {
        this.connection = connection;
        this.id = id;

        // Set up JFrame properties
        setTitle("Update Employee section");
        setSize(900, 700);
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

        // Header
        header = new JLabel("Update Employee", SwingConstants.CENTER);
        header.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
        header.setBounds(0, 0, getWidth(), 50);
        header.setOpaque(true); // Make the gray background visible
        header.setBackground(Color.LIGHT_GRAY);
        backGroundLabel.add(header);  // Add header to the background label

        // Search Field
        searchField = new JTextField();
        searchField.setBounds(210, 75, 250, 30);
        searchField.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(searchField);

        // Search Button
        searchBtn = new JButton("Search");
        searchBtn.setBounds(100, 74, 100, 29);
        searchBtn.setFocusPainted(false);
        searchBtn.setBackground(Color.lightGray);
        searchBtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
        searchBtn.addActionListener(new Controller());
        backGroundLabel.add(searchBtn);

        // ID Label
        idlbl = new JLabel("ID   :");
        idlbl.setBounds(120, 150, 150, 30);
        idlbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(idlbl);

        // ID Field
        idField = new JTextField();
        idField.setBounds(180, 153, 180, 32);
        idField.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
        idField.setEditable(false);
        idField.setBackground(Color.LIGHT_GRAY);
        backGroundLabel.add(idField);

        // First Name Label
        fnamelbl = new JLabel("First Name  :");
        fnamelbl.setBounds(50, 220, 150, 30);
        fnamelbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(fnamelbl);

        // First Name Field
        fnameField = new JTextField();
        fnameField.setBounds(180, 223, 180, 32);
        fnameField.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
        fnameField.setEditable(false);
        fnameField.setBackground(Color.LIGHT_GRAY);
        backGroundLabel.add(fnameField);

        // Last Name Label
        lnamelbl = new JLabel("Last Name  :");
        lnamelbl.setBounds(50, 290, 150, 30);
        lnamelbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(lnamelbl);

        // Last Name Field
        lnameField = new JTextField();
        lnameField.setBounds(180, 293, 180, 32);
        lnameField.setBackground(Color.DARK_GRAY);
        lnameField.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
        lnameField.setBackground(Color.LIGHT_GRAY);
        lnameField.setEditable(false);
        backGroundLabel.add(lnameField);

        // Position Label
        posistionlbl = new JLabel("Position   :");
        posistionlbl.setBounds(70, 360, 150, 30);
        posistionlbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(posistionlbl);

        // Position ComboBox
        String[] positions = {"Admin", "HR", "Employee"};
        positionComboBox = new JComboBox<>(positions);
        positionComboBox.setBounds(180, 363, 180, 32);
        positionComboBox.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(positionComboBox);

        // address Label
        addresslbl = new JLabel("Address :");
        addresslbl.setBounds(535, 150, 150, 30);
        addresslbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(addresslbl);

        // address Field
        addressField = new JTextField();
        addressField.setBounds(635, 153, 180, 32);
        addressField.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        backGroundLabel.add(addressField);

        // Phone Label
        phonelbl = new JLabel("Phone   :");
        phonelbl.setBounds(535, 220, 150, 30);
        phonelbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(phonelbl);

        // Phone Field
        phoneField = new JTextField();
        phoneField.setBounds(635, 223, 180, 32);
        phoneField.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(phoneField);

        // Email Label
        emaillbl = new JLabel("Email   :");
        emaillbl.setBounds(535, 290, 150, 30);
        emaillbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(emaillbl);

        // Email Field
        emailField = new JTextField();
        emailField.setBounds(635, 293, 180, 32);
        emailField.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        backGroundLabel.add(emailField);

        // Salary Label
        salarylbl = new JLabel("Salary   :");
        salarylbl.setBounds(535, 360, 150, 30);
        salarylbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(salarylbl);

        // Salary Field
        salaryField = new JTextField();
        salaryField.setBounds(635, 363, 180, 32);
        salaryField.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(salaryField);

        // Update Button
        updatebtn = new JButton("Update");
        updatebtn.setBounds(140, 490, 180, 70);
        updatebtn.setFocusPainted(false);
        updatebtn.setBackground(Color.lightGray);
        updatebtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
        updatebtn.addActionListener(new Controller());
        backGroundLabel.add(updatebtn);  // Add button to the background label

        // Back Button
        backbtn = new JButton("Back");
        backbtn.setBounds(370, 490, 180, 70);
        backbtn.setFocusPainted(false);
        backbtn.setBackground(Color.lightGray);
        backbtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
        backbtn.addActionListener(new Controller());
        backGroundLabel.add(backbtn);  // Add button to the background label

        // Exit Button
        exitbtn = new JButton("Exit");
        exitbtn.setBounds(600, 490, 180, 70);
        exitbtn.setFocusPainted(false);
        exitbtn.setBackground(Color.lightGray);
        exitbtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
        exitbtn.addActionListener(new Controller());
        backGroundLabel.add(exitbtn);  // Add button to the background label

        setVisible(true);
    }

    // A method to dispose this Frame
    void Dispose() {
        this.dispose();
    }

    // A method to extract the id from the search field
    int extractIDFromSearch() {
        String idAsString = searchField.getText();
        int id;
        try {
            id = Integer.parseInt(idAsString);
            return id;
        } catch (Exception e) {
            return -1;
        }
    }

    int extractID() {
        String idAsString = idField.getText();
        return Integer.parseInt(idAsString);
    }

    double extractSalary() {
        String salaryAsString = salaryField.getText();
        return Double.parseDouble(salaryAsString);
    }

    void search() throws SQLException {
        int idSearch = extractIDFromSearch();
        if (idSearch == -1) {
            JOptionPane.showMessageDialog(this, "Flied id",
                    "Failed", JOptionPane.ERROR_MESSAGE);
        } else {
            DBOperations dbOperations = new DBOperations(connection);
            ResultSet resultSet = dbOperations.Search(idSearch);
            while (resultSet.next()) {
                idField.setText(resultSet.getString(1));
                fnameField.setText(resultSet.getString(2));
                lnameField.setText(resultSet.getString(3));
                addressField.setText(resultSet.getString(4));
                phoneField.setText(resultSet.getString(5));
                emailField.setText(resultSet.getString(6));
                positionComboBox.setSelectedItem(resultSet.getObject(7));
                salaryField.setText(resultSet.getString(8));
            }
        }
    }

    void Update() throws SQLException {
        String address = addressField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String position = (String) positionComboBox.getSelectedItem();
        Double salary = extractSalary();
        int id = extractID();

        DBOperations dbOperations = new DBOperations(connection);
        dbOperations.Update(address, phone, email, position, salary, id);
    }

    // An inner class to control the buttons
    private class Controller implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == searchBtn) {
                try {
                    search();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(searchField, "Not found",
                            "Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getSource() == updatebtn) {
                try {
                    Update();
                    JOptionPane.showMessageDialog(searchField, "Updated Successfully");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(searchField, "Cannot Update",
                            "Failed", JOptionPane.ERROR_MESSAGE);
                }

            } else if (e.getSource() == backbtn) {
                Dispose();
                new AdminDashBoard(id, connection);

            } else if (e.getSource() == exitbtn) {
                System.exit(0);
            }
        }
    }
}