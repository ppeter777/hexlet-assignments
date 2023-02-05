package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    // BEGIN
    @Test
    void testTake() {

        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> result1 = new ArrayList<>(Arrays.asList(1, 2));
        assertThat(App.take(numbers1, 2)).isEqualTo(result1);

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> result2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        assertThat(App.take(numbers2, 8)).isEqualTo(result2);
    }

    @Test
    void testTake2() {

        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThat(App.take(numbers1, 0)).isEmpty();

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(70, 30, 10));
        assertThat(App.take(numbers2, 1)).isNotEmpty();
    }

    @Test
    void testTake3() {

        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        assertThat(App.take(numbers1, 7)).endsWith(7);

    }
    // END
}
