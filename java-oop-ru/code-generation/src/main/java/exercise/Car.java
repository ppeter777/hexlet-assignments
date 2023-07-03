package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Data
@AllArgsConstructor
@NoArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
   public static String serialize(Car car) throws JsonProcessingException {
       ObjectMapper objectMapper = new ObjectMapper();
       return objectMapper.writeValueAsString(car);
   }

    public Car unserialize(String car) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(car, Car.class);
    }
    // END
}
