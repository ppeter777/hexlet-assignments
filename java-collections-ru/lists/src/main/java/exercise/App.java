package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        word = word.toLowerCase();
        symbols = symbols.toLowerCase();
        List<String> symbolsList = new ArrayList<>();
        for (var i = 0; i < symbols.length(); i++) {
            symbolsList.add(symbols.substring(i, i + 1));
        }
        for (var i = 0; i < word.length(); i++) {
            if (!symbolsList.contains(word.substring(i, i + 1))) {
                return false;
            } else {
                symbolsList.remove(word.substring(i, i + 1));
            }
        }
        return true;
    }
}
//END
