package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String input) {
        // String content = Files.readString("s.conf");
        String output = Stream.of(input)
                .map(s -> s.split("\n"))
                .flatMap(line -> Stream.of(line))
                .filter(name -> name.startsWith("environment=\""))
                .map(s -> s.replace("environment=", ""))
                .map(s -> s.replace("\"", ""))
                .map(s -> s.split(","))
                .flatMap(element -> Stream.of(element))
                .filter(name -> name.contains("X_FORWARDED_"))
                .map(s -> s.replace("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
        return output;
    }
}
//END
