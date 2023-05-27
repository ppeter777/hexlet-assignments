package exercise;

// BEGIN
public class Flat implements Home {
    double area;
    double balconyArea;
    int floor;
    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
    public double getArea() {
        return area + balconyArea;
    }

    public int compareTo(Home apartment) {
        if (this.area > apartment.getArea()) {
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }
    public int compareTo(Flat flat) {
        if (this.area > flat.area) {
            return 1;
        } else {
            return -1;
        }
    }
}
// END
