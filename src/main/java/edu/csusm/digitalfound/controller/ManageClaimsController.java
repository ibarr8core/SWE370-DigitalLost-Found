package controller;

import db.DBHandler;
import model.Item;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ManageClaimsController extends JPanel {

    private final DBHandler dbHandler = DBHandler.getInstance();
    private final DefaultTableModel tableModel;
    private final JTable table;
    private final List<Item> items;  // same order as table rows

    public ManageClaimsController() {
        setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Manage Claims");
        title.setFont(new Font("SansSerif", Font.BOLD, 18));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title, BorderLayout.NORTH);

        // Load all items for now (you could swap to dbHandler.getClaimedItems())
        items = dbHandler.getAllItems();

        String[] columns = {"Item Name", "Description", "Location", "Status"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // read-only table
            }
        };

        // Fill table rows from items list
        for (Item item : items) {
            tableModel.addRow(new Object[]{
                    item.getName(),
                    item.getDescription(),
                    item.getLocation(),
                    item.getClaimStatus()
            });
        }

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Bottom buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton pendingButton = new JButton("Set Pending");
        JButton approvedButton = new JButton("Set Approved");
        JButton rejectedButton = new JButton("Set Rejected");

        buttonPanel.add(pendingButton);
        buttonPanel.add(approvedButton);
        buttonPanel.add(rejectedButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Button actions
        pendingButton.addActionListener(e -> updateStatus("Pending", false));
        approvedButton.addActionListener(e -> updateStatus("Approved", true));
        rejectedButton.addActionListener(e -> updateStatus("Rejected", false));
    }

    private void updateStatus(String status, boolean markClaimed) {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this,
                    "Please select an item first.",
                    "No Selection",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Item item = items.get(row);
        item.setClaimStatus(status);
        item.setClaimed(markClaimed);

        // update table display
        tableModel.setValueAt(status, row, 3);
    }
}
