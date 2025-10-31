 package edu.csusm.digitalfound;
 
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Digital Lost & Found");
            frame.setSize(600, 450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JLabel("Digital Lost & Found!", SwingConstants.CENTER));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
