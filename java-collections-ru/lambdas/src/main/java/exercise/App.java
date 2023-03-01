package exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .sorted((user1, user2) -> user1.get("birthday").compareTo(user2.get("birthday")))
                .filter(user -> user.get("gender").equals("male"))
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }
}
// END
