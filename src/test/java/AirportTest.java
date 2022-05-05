import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class AirportTest {

    @Test
    void addPassenger__ToFlight() {
//        Given
        Flight testFlight = new Flight(Destination.LONDON, 1);
        Passenger testPassenger1 = new Passenger("Lewis", "Broadhurst", "lmb@gmail.com", 45);
        Passenger testPassenger2 = new Passenger("Peace", "Akib", "pa@gmail.com", 23);

//        When
        testFlight.addPassenger(testPassenger1);
        testFlight.addPassenger(testPassenger2);

//        Then
        assertEquals(testPassenger1.getFirstName(), testFlight.getPassengers().get(0).getFirstName());
        assertEquals(testPassenger1.getLastName(), testFlight.getPassengers().get(0).getLastName());

        assertEquals(testPassenger2.getEmail(), testFlight.getPassengers().get(1).getEmail());
        assertEquals(testPassenger2.getPassportID(), testFlight.getPassengers().get(1).getPassportID());

    }

    @Test
    void addFlight__Test() {
//        Given
        Airport testAirport = new Airport();

//        When
        testAirport.addFlight(Destination.LONDON, 42);

//        Then
        assertEquals(42, testAirport.getAllFlights().get(0).getFlightId());
        assertEquals(Destination.LONDON, testAirport.getAllFlights().get(0).getDestination());

    }

    @Test
    void displayFlights__test() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

//        Given
        Airport testAirport = new Airport();

//        When
        testAirport.addFlight(Destination.HAWAII, 1);
        testAirport.displayFlights();

        String expectedOutput = "HAWAII, Flight number 1\n";

//        Then

        assertEquals(expectedOutput, outContent.toString());
    }

//    test to remove existing flight
    @Test
    void removeExistingFlight_test(){
        //given airport and flight
        Airport testAirport = new Airport();
        Flight flight1 = new Flight(Destination.LONDON, 1234);

//    When
        testAirport.removeFlight(flight1);

//    Then
        assertFalse(testAirport.getAllFlights().contains(flight1));
    }




}