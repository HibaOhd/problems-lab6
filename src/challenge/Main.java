package challenge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Itinerary itinerary = new Itinerary();

        itinerary.addPlace(new Place("Sydney", 0));
        itinerary.addPlace(new Place("Adelaide", 1374));
        itinerary.addPlace(new Place("Alice Springs", 2771));
        itinerary.addPlace(new Place("Brisbane", 917));
        itinerary.addPlace(new Place("Darwin", 3972));
        itinerary.addPlace(new Place("Melbourne", 877));
        itinerary.addPlace(new Place("Perth", 3923));

        itinerary.printItinerary();
        navigate(itinerary.getPlaces());
    }
    private static void navigate(LinkedList<Place> places) {
        Scanner scanner = new Scanner(System.in);
        ListIterator<Place> iterator = places.listIterator();
        boolean forward = true;

        printMenu();

        if (!iterator.hasNext()) return;
        System.out.println("Now visiting: " + iterator.next());

        boolean quit = false;
        while (!quit) {
            System.out.print("Choose an option: ");
            String action = scanner.nextLine().trim().toUpperCase();
            switch (action) {
                case "F":
                    if (!forward) {
                        if (iterator.hasNext()) iterator.next();
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now visiting: " + iterator.next());
                    } else {
                        System.out.println("End of the list reached");
                        forward = false;
                    }
                    break;
                case "B":
                    if (forward) {
                        if (iterator.hasPrevious()) iterator.previous();
                        forward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now visiting: " + iterator.previous());
                    } else {
                        System.out.println("Start of the list reached");
                        forward = true;
                    }
                    break;
                case "L":
                    System.out.println("Places to visit:");
                    for (Place p : places) System.out.println(" - " + p);
                    break;
                case "M":
                    printMenu();
                    break;
                case "Q":
                    System.out.println("Exiting itinerary navigation...");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Try again");
            }
        }
    }
    private static void printMenu() {
        System.out.println("""
            Available actions (select word or letter):
            (F)orward
            (B)ackward
            (L)ist Places
            (M)enu
            (Q)uit
            """);
    }
}

