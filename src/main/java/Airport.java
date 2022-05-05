import java.util.ArrayList;
import java.util.List;

public class Airport {

    private List<Flight> allFlights;

    //constructor
    public Airport() {
        this.allFlights = new ArrayList<Flight>();
    }

    //behaviours

    public List<Flight> getAllFlights() {
        return allFlights;
    }

    public void displayFlights() {
        System.out.println(allFlights.toString());
    }

    public void addPassengerToFlight(Passenger passenger, Flight flight) {
        flight.addPassenger(passenger);
    }

    public void addFlight(Destination destination, int flightId) {
        allFlights.add(new Flight (destination, flightId));
    }

    public void removeFlight(Flight flight){allFlights.remove(flight);}


    @Override
    public String toString() {
        return "Airport{" +
                "allFlights=" + allFlights +
                '}';
    }
}
