package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {

    int[] array;
    int max;
    MaxThread(int[] array) {
        this.array = array;
        this.max = Arrays.stream(array).max().getAsInt();
    }
    @Override
    public void run() {
    }

    public int getMax() {
        return max;
    }
}
// END
