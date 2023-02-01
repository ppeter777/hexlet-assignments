package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map getWordCount(String sentence) {
        Map<String, Integer> sentenceMap = new HashMap<>();
        if (sentence.equals("")) {
            return sentenceMap;
        }
        var words = sentence.split(" ");
        for (var word: words) {
            sentenceMap.put(word, wordCount(words, word));
        }
        return sentenceMap;
    }
    public static int wordCount(String[] words, String word) {
        var count = 0;
        for (var i: words) {
            if (i.equals(word)) {
                count++;
            }
        }
        return count;
    }
    public static String toString(Map dictionary) {
        if (dictionary.isEmpty()) {
            return "{}";
        }
        var keys = dictionary.keySet();
        var output = new StringBuilder();
        output.append("{\n");
        for (var key: keys) {
            output.append("  " + key + ": " + dictionary.get(key) + "\n");
        }
        output.append("}");
        return output.toString();
    }
}
//END
