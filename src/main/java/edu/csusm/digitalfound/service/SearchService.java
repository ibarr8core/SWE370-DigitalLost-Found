package service;

import db.DBHandler;
import model.Item;
import java.util.List;

public class SearchService {
    private final DBHandler dbHandler = DBHandler.getInstance();

    public List<Item> searchItems(String keyword) {
        return dbHandler.searchItems(keyword);
    }
}
