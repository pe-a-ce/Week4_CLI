import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void displayMenu() {
        fail();
    }

    @Test
    void addNewFlight() {
        fail();
    }

    @Test
    void displayFlights() {
        fail();
    }

    @Test
    void addPassenger() {
        fail();
    }

    @Test
    void bookAPassenger__test() {
//        Given
        Passenger testPassenger = new Passenger("Rick", "Roll", "u_got_rolled@rolled.com", 1);
        Flight testFlight = new Flight(Destination.PALMA, 12);
        Airport testAirport = new Airport();

//        When
        testAirport.addPassengerToFlight(testPassenger, testFlight);

//        Then
        assertEquals("Rick", testFlight.getPassengers().get(0).getFirstName());
    }



    @Test
    void cancelAnExistingFlight() {
        fail();
    }

    @Test
    void passengerNotFound() {
        fail();
    }
}