package db;

import model.Item;
import java.util.*;

public class DBHandler {
    private static DBHandler instance;
    private final List<Item> items = new ArrayList<>();

    private DBHandler() {}

    public static synchronized DBHandler getInstance() {
        if (instance == null) instance = new DBHandler();
        return instance;
    }

    // Save new item into in-memory list
    public void insertItem(Item item) {
        items.add(item);
        System.out.println("[DB] Item saved: " + item);
    }

    //  NEW: Search items by keyword (name or description)
    public List<Item> searchItems(String keyword) {
        List<Item> results = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    item.getDescription().toLowerCase().contains(keyword.toLowerCase()) ||
                    item.getLocation().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(item);
            }
        }
        return results;
    }

    // Optional: view all items
    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }
}
