package srcCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class DeleteEmployee extends JFrame {

    private final ImageIcon frameIcon, originalBackGround, scaledBackGround;
    private final Image imageBackGround;
    private final JLabel backGroundLabel, header, idlbl, fnamelbl, lnamelbl;
    private final JTextField idfield, fnamefield, lnamefield;
    private final JButton delbtn, exitbtn, backbtn;
    private final DBConnection connection;
    private final int id;

    public DeleteEmployee(int id, DBConnection connection) {
        this.connection = connection;
        this.id = id;

        // Set up JFrame properties
        setTitle("Delete Employee section");
        setSize(600, 450);
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
        header = new JLabel("Remove Employee", SwingConstants.CENTER);
        header.setFont(new Font("Comic Sans MS", Font.ITALIC, 30));
        header.setBounds(0, 0, getWidth(), 50);
        header.setOpaque(true); // Make the gray background visible
        header.setBackground(Color.LIGHT_GRAY);
        backGroundLabel.add(header);  // Add header to the background label

        // ID Label
        idlbl = new JLabel("ID   :");
        idlbl.setBounds(170, 90, 150, 30);
        idlbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(idlbl);

        // ID Field
        idfield = new JTextField();
        idfield.setBounds(230, 93, 180, 32);
        idfield.setFont(new Font("Comic Sans MS", Font.ITALIC, 23));
        backGroundLabel.add(idfield);

        // First Name Label
        fnamelbl = new JLabel("First Name  :");
        fnamelbl.setBounds(100, 160, 150, 30);
        fnamelbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(fnamelbl);

        // First Name Field
        fnamefield = new JTextField();
        fnamefield.setBounds(230, 163, 180, 32);
        fnamefield.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(fnamefield);


        // Last Name Label
        lnamelbl = new JLabel("Last Name  :");
        lnamelbl.setBounds(100, 230, 150, 30);
        lnamelbl.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(lnamelbl);

        // Last Name Field
        lnamefield = new JTextField();
        lnamefield.setBounds(230, 233, 180, 32);
        lnamefield.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backGroundLabel.add(lnamefield);

        // delete Button
        delbtn = new JButton("Remove");
        delbtn.setBounds(80, 320, 120, 40);
        delbtn.setFocusPainted(false);
        delbtn.setBackground(Color.lightGray);
        delbtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        delbtn.addActionListener(new Controller());
        backGroundLabel.add(delbtn);  // Add button to the background label

        // Back Button
        backbtn = new JButton("Back");
        backbtn.setBounds(240, 320, 120, 40);
        backbtn.setFocusPainted(false);
        backbtn.setBackground(Color.lightGray);
        backbtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backbtn.addActionListener(new Controller());
        backGroundLabel.add(backbtn);  // Add button to the background label

        // Exit Button
        exitbtn = new JButton("Exit");
        exitbtn.setBounds(400, 320, 120, 40);
        exitbtn.setFocusPainted(false);
        exitbtn.setBackground(Color.lightGray);
        exitbtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        exitbtn.addActionListener(new Controller());
        backGroundLabel.add(exitbtn);  // Add button to the background label


        setVisible(true);
    }

    // Dispose this Frame
    void Dispose() {
        this.dispose();
    }

    // A method to extract the id from the id field
    int extractID() {
        String idAsString = idfield.getText();
        int id = Integer.parseInt(idAsString);
        return id;
    }

    // Clear the field after delete
    void clearFields() {
        idfield.setText("");
        fnamefield.setText("");
        lnamefield.setText("");
    }

    // A method to delete the emp
    void DeleteEmp() {
        int id = extractID();
        String fname = fnamefield.getText();
        String lname = lnamefield.getText();
        try {
            DBOperations db = new DBOperations(connection);
            db.Delete(id, fname, lname);
            JOptionPane.showMessageDialog(this, "The employee " + id + " Removed Successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Deleting Failed", JOptionPane.ERROR_MESSAGE);
        }
        clearFields();


    }

    // An inner class to control the buttons
    private class Controller implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == delbtn) {
                DeleteEmp();

            } else if (e.getSource() == backbtn) {
                Dispose();
                new AdminDashBoard(id, connection);

            } else if (e.getSource() == exitbtn) {
                System.exit(0);
            }
        }
    }

}