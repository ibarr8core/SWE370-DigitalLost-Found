package controller;

import model.Item;
import service.ReportService;

import javax.swing.*;
import java.awt.*;

public class ReportController extends JPanel {
    private final ReportService reportService = new ReportService();

    private final JTextField nameField = new JTextField(20);
    private final JTextField descField = new JTextField(20);
    private final JTextField locField = new JTextField(20);
    private final JButton submitButton = new JButton("Submit");

    public ReportController() {
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Item Name:"));
        add(nameField);

        add(new JLabel("Description:"));
        add(descField);

        add(new JLabel("Location:"));
        add(locField);

        add(new JLabel()); // empty cell for layout
        add(submitButton);

        submitButton.addActionListener(e -> handleSubmit());
    }

    private void handleSubmit() {
        String name = nameField.getText().trim();
        String desc = descField.getText().trim();
        String loc = locField.getText().trim();

        Item item = new Item(name, desc, loc);
        reportService.reportLostItem(item);

        JOptionPane.showMessageDialog(this,
                "Lost item submitted!\n" +
                        "Name: " + name + "\nDescription: " + desc + "\nLocation: " + loc,
                "Success",
                JOptionPane.INFORMATION_MESSAGE);

        // Clear fields after submission
        nameField.setText("");
        descField.setText("");
        locField.setText("");
    }
}
