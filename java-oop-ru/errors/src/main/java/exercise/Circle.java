package exercise;

// BEGIN
public class Circle {
    int radius;

    public Circle(Point point, int radius) {

        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return (radius * radius * Math.PI);
    }
}

// END
