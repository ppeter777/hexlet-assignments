package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {
        Home flat1 = new Flat(39, 3, 6);
        System.out.println(flat1.getArea());
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));
        System.out.println(buildApartmentsList(apartments,2));
    }

    public static List<String> buildApartmentsList(List<Home> apartments, int number) {
        List<Home> sortedApartments = apartments.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .toList();
        List<String> output = new ArrayList<>();
        int i = 1;
        for (Home apartment : sortedApartments) {
            output.add(apartment.toString());
            i++;
            if (i > number) {
                break;
            }
        }
        return output;
    }
}
// END
