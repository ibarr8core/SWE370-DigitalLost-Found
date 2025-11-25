package service;

import model.Item;
import db.DBHandler;
import util.Validator;

public class ReportService {
    private final DBHandler dbHandler = DBHandler.getInstance();

    public void reportLostItem(Item item) {
        if (Validator.isValidItem(item)) {
            dbHandler.insertItem(item);
            System.out.println("Lost item successfully reported.");
        } else {
            System.out.println("Invalid item details. Please try again.");
        }
    }
}
