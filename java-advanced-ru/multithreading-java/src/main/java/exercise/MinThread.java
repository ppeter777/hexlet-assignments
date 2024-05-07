package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {

    int[] array;
    int min;
    MinThread(int[] array) {
        this.array = array;
        this.min = Arrays.stream(array).min().getAsInt();
    }
    @Override
    public void run() {
    }

    public int getMin() {
        return min;
    }
}
// END
