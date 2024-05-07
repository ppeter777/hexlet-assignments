package exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(getMinMax(a));
    }
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
        public static Map<String, Integer> getMinMax(int[] input) {
            Map<String, Integer> output = new HashMap<>();
            MaxThread max = new MaxThread(input);
            MinThread min = new MinThread(input);
            max.start();
            min.start();
            output.put("min", min.getMin());
            output.put("max", max.getMax());
            return output;
        }
    // END
}
