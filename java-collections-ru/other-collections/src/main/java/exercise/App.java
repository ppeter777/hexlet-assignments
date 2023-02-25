package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map genDiff(Map<String, Object> inputMap1, Map<String, Object> inputMap2) {
        Map<String, String> outputMap = new LinkedHashMap<>();
        Map<String, Object> mergedMap = new LinkedHashMap<>();
        mergedMap.putAll(inputMap1);
        mergedMap.putAll(inputMap2);
        for (Map.Entry<String, Object> entry: mergedMap.entrySet()) {
            if (inputMap1.containsKey(entry.getKey()) && inputMap2.containsKey(entry.getKey())) {
                if (inputMap1.get(entry.getKey()) == inputMap2.get(entry.getKey())) {
                    outputMap.put(entry.getKey(), "unchanged");
                } else {
                    outputMap.put(entry.getKey(), "changed");
                }
            } else if (!inputMap1.containsKey(entry.getKey())) {
                outputMap.put(entry.getKey(), "added");
            } else {
                outputMap.put(entry.getKey(), "deleted");
            }
        }
        return outputMap;
    }
}
//END
