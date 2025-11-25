package util;

import model.Item;

public class Validator {
    public static boolean isValidItem(Item item) {
        return item.getName() != null && !item.getName().isBlank()
                && item.getDescription() != null && !item.getDescription().isBlank()
                && item.getLocation() != null && !item.getLocation().isBlank();
    }
}
