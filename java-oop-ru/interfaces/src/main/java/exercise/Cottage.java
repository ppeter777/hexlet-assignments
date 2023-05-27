package exercise;

// BEGIN
public class Cottage implements Home{
    double area;
    int floorCount;
    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    public double getArea() {
        return area;
    }

    public int compareTo(Home apartment) {
        if (this.area > apartment.getArea()) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }
}
// END
