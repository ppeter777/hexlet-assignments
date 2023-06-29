package exercise;

// BEGIN
public class App {
    public static void printSquare (Circle circle) {
        try {
            System.out.println(Math.round((float) circle.getSquare()));
        }
        catch (NegativeRadiusException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
