package srcCode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class View extends JFrame {

    private JTable table;
    private final ResultSet resultSet;
    private final ImageIcon frameIcon;
    private final JButton backBtn, exitBtn;
    private final JPanel buttonPanel;
    private final int id;
    private final String type;
    private final DBConnection connection;

    public View(ResultSet resultSet, DBConnection connection, int id, String type) {
        this.resultSet = resultSet;
        this.connection = connection;
        this.id = id;
        this.type = type;

        // Create JFrame
        setTitle("View");
        frameIcon = new ImageIcon(ClassLoader.getSystemResource("icons/frameIcon.png"));
        setIconImage(frameIcon.getImage());
        setSize(800, 400); // Increased height to accommodate buttons
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        try {
            table = getView();
            JScrollPane scrollPane = new JScrollPane(table); // Add table to JScrollPane
            add(scrollPane, BorderLayout.CENTER); // Add JScrollPane to JFrame
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Failed", JOptionPane.ERROR_MESSAGE);
        }

        // Create a panel for buttons and add it to the bottom of the frame
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        // Create buttons
        exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        exitBtn.setBackground(Color.lightGray);
        exitBtn.setFocusPainted(false);
        exitBtn.addActionListener(new Controller());
        buttonPanel.add(exitBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        backBtn.setBackground(Color.lightGray);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(new Controller());
        buttonPanel.add(backBtn);


        // Add a button panel to the SOUTH of the frame
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // A method to return the view
    private JTable getView() throws SQLException {
        DefaultTableModel tableModel = buildTableModel(resultSet);

        JTable table = new JTable(tableModel);
        table.setRowHeight(40);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.GRAY);
        header.setForeground(Color.WHITE);

        return table;
    }

    // A method to convert the ResultSet to DefaultTableModel
    private DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();

        // Collect column names
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            columnNames.add(metaData.getColumnName(columnIndex));
        }

        // Collect rows data
        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> row = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row.add(resultSet.getObject(columnIndex));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }

    // A method to dispose this Frame
    void Dispose() {
        this.dispose();
    }

    // return to the DashBoard
    void goBack() {
        switch (type) {
            case "emp":
                new EmployeeDashBoard(id, connection);
                break;
            case "hr":
                new HrDashBoard(id, connection);
                break;
            case "admin":
                new AdminDashBoard(id, connection);
                break;
            default:
                JOptionPane.showMessageDialog(this, type + " not a DashBoard type",
                        "Failed", JOptionPane.ERROR_MESSAGE);

        }
    }


    // An inner class to control the button actions
    private class Controller implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == backBtn) {
                Dispose();
                goBack();

            } else if (e.getSource() == exitBtn) {
                System.exit(0);
            }
        }
    }
}
