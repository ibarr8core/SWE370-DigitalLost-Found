package controller;

import model.Item;
import service.SearchService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SearchController extends JPanel {
    private final SearchService searchService = new SearchService();

    private final JTextField searchField = new JTextField(20);
    private final JButton searchButton = new JButton("Search");
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> resultsList = new JList<>(listModel);

    public SearchController() {
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Search Keyword:"));
        topPanel.add(searchField);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultsList), BorderLayout.CENTER);

        searchButton.addActionListener(e -> handleSearch());
    }

    private void handleSearch() {
        String keyword = searchField.getText().trim();
        listModel.clear();

        if (keyword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a keyword.");
            return;
        }

        List<Item> results = searchService.searchItems(keyword);
        if (results.isEmpty()) {
            listModel.addElement("❌ No items found.");
        } else {
            for (Item item : results) {
                listModel.addElement(item.toString());
            }
        }
    }
}
