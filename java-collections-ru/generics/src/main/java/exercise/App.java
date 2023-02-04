package exercise;

import java.util.*;

// BEGIN
public class App {

    public static List findWhere(List<Map<String, String>> books, Map where) {
        List<Map> output = new ArrayList<>();
        for (var book: books) {
            if (checkBook(book, where)) {
                output.add(book);
            }
        }
        return output;
    }

    public static boolean checkBook (Map book, Map <String, String> where) {
        for (Map.Entry<String, String> entryInWhere: where.entrySet()) {
            if (book.get(entryInWhere.getKey()) != entryInWhere.getValue()) {
                return false;
            }
        }
        return true;
    }
}
//END
