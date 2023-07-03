package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        Files.writeString(path, Car.serialize(car), StandardOpenOption.WRITE);

    }
    public static Car extract(Path path) throws IOException {
        String content = Files.readString(path);
        return new Car().unserialize(content);
    }
}
// END
