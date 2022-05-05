import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Flight {


    //Properties of flight class

    private Destination destination;
    private int flightId;
    private List<Passenger> passengers;


    //Getters & Setters

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }


    //Constructors

    public Flight(Destination destination, int flightId) {
        this.destination = destination;
        this.flightId = flightId;
        this.passengers = new ArrayList<>();
    }


    //Methods

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }

    public void removePassenger(Passenger passenger){
        this.passengers.remove(passenger);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "destination=" + destination +
                ", flightId=" + flightId +
                ", passengers=" + passengers +
                '}';
    }
}
