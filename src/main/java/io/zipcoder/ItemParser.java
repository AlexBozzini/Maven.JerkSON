package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    private String name;
    private Double price;
    private String type;
    private String expiration;
// sample: naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##

    public List<Item> parseItemList(String valueToParse) {
        String pattern = "";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(valueToParse);
        return null;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String nameField = "(\\w+)";
        String keyValueSeparator = "[:@^*%]";
        String foodName = "(\\w+)";
        String pairSeparator = ";";
        String priceField = "(\\w+)";
        String priceDouble = "(\\d+\\.\\d{0,2})";
        String typeField = "(\\w+)";
        String typeDescription = "(\\w+)";
        String expirationField = "(\\w+)";
        String expirationDate = "(\\d{1,2}/\\d{1,2}/\\d{4})";
        String stop = "(##)";
        String pattern = nameField + keyValueSeparator + foodName + pairSeparator + priceField + keyValueSeparator +
                priceDouble + pairSeparator + typeField + keyValueSeparator + typeDescription + pairSeparator + expirationField + keyValueSeparator + expirationDate + stop;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(singleItem);

        if (m.matches()) {
            name = m.group(2).toLowerCase();
            price = Double.valueOf(m.group(4).toLowerCase());
            type = m.group(6).toLowerCase();
            expiration = m.group(8).toLowerCase();

            return new Item(name, price, type, expiration);
        } else {
            throw new ItemParseException();
        }
    }
}
