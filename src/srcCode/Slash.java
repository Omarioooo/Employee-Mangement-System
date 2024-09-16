package srcCode;

import javax.swing.*;
import java.awt.*;

public class Slash extends JFrame {

    ImageIcon originalIcon, scaledIcon, frameIcon;
    Image image;
    JLabel imageLabel;


    public Slash() {
        // Create JFrame
        setTitle("Loading: Employees System");
        frameIcon = new ImageIcon(ClassLoader.getSystemResource("icons/frameIcon.png"));
        setIconImage(frameIcon.getImage());
        setSize(1170, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Scaling the GIF
        originalIcon = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        image = originalIcon.getImage().getScaledInstance(1170, 650, Image.SCALE_DEFAULT);
        scaledIcon = new ImageIcon(image);
        imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(0, 0, 1170, 650);
        add(imageLabel);

        // Set the frame visible
        setVisible(true);

        // Sleep the thread for 5_Sec before close the page
        try {
            Thread.sleep(5000);
            setVisible(false);
            this.dispose();
            new Login();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
