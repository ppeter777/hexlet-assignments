package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        List<String> notValidated = new ArrayList<>();
        for (var field: fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(address) == null) {
                        notValidated.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return notValidated;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Field[] fields = address.getClass().getDeclaredFields();
        Map<String, List<String>> notValidated = new HashMap<>();
        for (var field: fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(address) == null) {
                        notValidated.put(field.getName(), List.of("can not be null"));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            if (field.isAnnotationPresent(MinLength.class)) {
                field.setAccessible(true);
                int minLength = field.getAnnotation(MinLength.class).minLength();
                int valueLength = 0;
                try {
                    valueLength = field.get(address).toString().length();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (valueLength < minLength) {
                    notValidated.put(field.getName(), List.of("length less than 4"));
                }
            }
        }
        return notValidated;
    }
}
// END
