package challenge;

import java.util.LinkedList;
import java.util.ListIterator;

public class Itinerary {
    private LinkedList<Place> places = new LinkedList<>();
    public boolean addPlace(Place newPlace) {
        ListIterator<Place> iterator = places.listIterator();
        while (iterator.hasNext()) {
            Place current = iterator.next();
            if (current.getName().equalsIgnoreCase(newPlace.getName())) {
                System.out.println(newPlace.getName() + " is already in the list");
                return false;
            } else if (current.getDistance() > newPlace.getDistance()) {
                iterator.previous();
                iterator.add(newPlace);
                return true;
            }
        }
        places.add(newPlace);
        return true;
    }
    public void printItinerary() {
        System.out.println("Itinerary:");
        for (Place p:places) {
            System.out.println(" - " + p);
        }
    }
    public LinkedList<Place> getPlaces() {
        return places;
    }
}
