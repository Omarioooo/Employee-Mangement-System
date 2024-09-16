package srcCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddEmployee extends JFrame {

    private final ImageIcon frameIcon, originalBackGround, scaledBackGround;
    private final Image imageBackGround;
    private final JLabel backGroundLabel, header, idlbl, fnamelbl, lnamelbl,
            addresslbl, phonelbl, emaillbl, posistionlbl, salarylbl;
    private final JTextField idfield, fnamefield, lnamefield, phonefield,
            emailfield, salaryfield, addressfield;
    private final JComboBox<String> positionComboBox;
    private final JButton addbtn, exitbtn, backbtn;
    private final DBConnection connection;
    private final int id;
    private final String type;

    public AddEmployee(DBConnection connection, int id, String type) {
        this.connection = connection;
        this.id = id;
        this.type = type;

        // Set up JFrame properties
        setTitle("Add Employee section");
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
        header = new JLabel("Add Employee", SwingConstants.CENTER);
        header.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
        header.setBounds(0, 0, getWidth(), 50);
        header.setOpaque(true); // Make the gray background visible
        header.setBackground(Color.LIGHT_GRAY);
        backGroundLabel.add(header);  // Add header to the background label

        // ID Label
        idlbl = new JLabel("ID   :");
        idlbl.setBounds(120, 150, 150, 30);
        idlbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(idlbl);

        // ID Field
        idfield = new JTextField();
        idfield.setBounds(180, 153, 180, 32);
        idfield.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
        idfield.setText("  ######");
        idfield.setBackground(Color.darkGray);
        idfield.setEnabled(false);
        backGroundLabel.add(idfield);

        // First Name Label
        fnamelbl = new JLabel("First Name  :");
        fnamelbl.setBounds(50, 220, 150, 30);
        fnamelbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(fnamelbl);

        // First Name Field
        fnamefield = new JTextField();
        fnamefield.setBounds(180, 223, 180, 32);
        fnamefield.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(fnamefield);


        // Last Name Label
        lnamelbl = new JLabel("Last Name  :");
        lnamelbl.setBounds(50, 290, 150, 30);
        lnamelbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(lnamelbl);

        // Last Name Field
        lnamefield = new JTextField();
        lnamefield.setBounds(180, 293, 180, 32);
        lnamefield.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(lnamefield);

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
        addressfield = new JTextField();
        addressfield.setBounds(635, 153, 180, 32);
        addressfield.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(addressfield);


        // Phone Label
        phonelbl = new JLabel("Phone   :");
        phonelbl.setBounds(535, 220, 150, 30);
        phonelbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(phonelbl);

        // Phone Field
        phonefield = new JTextField();
        phonefield.setBounds(635, 223, 180, 32);
        phonefield.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(phonefield);


        // Email Label
        emaillbl = new JLabel("Email   :");
        emaillbl.setBounds(535, 290, 150, 30);
        emaillbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(emaillbl);

        // Email Field
        emailfield = new JTextField();
        emailfield.setBounds(635, 293, 180, 32);
        emailfield.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(emailfield);


        // Salary Label
        salarylbl = new JLabel("Salary   :");
        salarylbl.setBounds(535, 360, 150, 30);
        salarylbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(salarylbl);

        // Salary Field
        salaryfield = new JTextField();
        salaryfield.setBounds(635, 363, 180, 32);
        salaryfield.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(salaryfield);

        // Add Button
        addbtn = new JButton("ADD");
        addbtn.setBounds(140, 490, 180, 70);
        addbtn.setFocusPainted(false);
        addbtn.setBackground(Color.lightGray);
        addbtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
        addbtn.addActionListener(new Controller());
        backGroundLabel.add(addbtn);  // Add button to the background label

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

    void goBack(int id, DBConnection connection, String type) {
        switch (type) {
            case "admin":
                new AdminDashBoard(id, connection);
                break;
            case "hr":
                new HrDashBoard(id, connection);
                break;
            default:
                JOptionPane.showMessageDialog(this, type + " not a DashBoard",
                        "Failed", JOptionPane.ERROR_MESSAGE);

        }
    }

    double executeSalary() throws Exception {
        String salaryAsString = salaryfield.getText();

        return Double.parseDouble(salaryAsString);
    }

    void addEmp() {

        try {
            String fname = fnamefield.getText();
            String lname = lnamefield.getText();
            String address = addressfield.getText();
            String phone = phonefield.getText();
            String email = emailfield.getText();
            String position = (String) positionComboBox.getSelectedItem();
            double salary = executeSalary();

            // Inserting into DB
            DBOperations db = new DBOperations(connection);
            db.Add(fname, lname, address, phone, email, position, salary);

            JOptionPane.showMessageDialog(this, "The employee is added successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "why not adddddd",
                    "Adding failed", JOptionPane.ERROR_MESSAGE);
        }
    }


    // An inner class to control the buttons
    private class Controller implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == addbtn) {
                addEmp();

            } else if (e.getSource() == backbtn) {
                Dispose();
                goBack(id, connection, type);

            } else if (e.getSource() == exitbtn) {
                System.exit(0);
            }
        }
    }
}
