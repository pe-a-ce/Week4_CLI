import java.util.*;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) {

        Airport ukAirport = new Airport();
        List<Passenger> emptyPassengers = new ArrayList<>();


        emptyPassengers.add(new Passenger("John", "Smith", "Jsmith@Gmail.com", 1));
        //        Just as a placeholder to prove case 2 is functional.
        ukAirport.addFlight(Destination.BARCELONA, 1);
        ukAirport.addFlight(Destination.MIAMI, 2);
        ukAirport.addFlight(Destination.PARIS, 3);
        //        End of placeholder.

        Scanner in = new Scanner(System.in);

        int option = -1;
        do {

            displayMenu();
            boolean loop = true;
            while(loop) {
                try{
                    option = in.nextInt();
                    loop = false;
                } catch (Exception e) {
                    System.out.println("Not a number, grr, try again!");
                    in.next();
                }
            }


            System.out.println("You chose option " + option);

            switch (option) {
                case 1:
                    addNewFlight(in, ukAirport, emptyPassengers);
                    break;
                case 2:
                    displayFlights(in, ukAirport, emptyPassengers);
                    break;
//                After we complete all the test cases, can add some logic in so when a plane has 10 passengers,
//                it is 'Full' and is not 'Available' anyone.
                case 3:
                    addPassenger(in, emptyPassengers);
                    break;
                case 4:
                    bookAPassenger(in, ukAirport, emptyPassengers);
                    break;
                case 5:
                    cancelAnExistingFlight(in, ukAirport, emptyPassengers);
                    break;
                case 0:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Try again. Pick a number between 0 and 5");
            }
        } while (option != 0);
    }

    public static void displayMenu() {
//        exception if they do not pick an option 0-5
        System.out.println("-------------------------------------");
        System.out.println("Take flight with Take Flight airways!");
        System.out.println("Option 0: Exit");
        System.out.println("Option 1: Add a new flight");
        System.out.println("Option 2: Display all available flights");
        System.out.println("Option 3: Add a new passenger");
        System.out.println("Option 4: Book a passenger onto an existing flight");
        System.out.println("Option 5: Cancel an existing flight");
        System.out.println("-------------------------------------");
        System.out.println("Please choose an option: ");
    }

    public static void addNewFlight(Scanner in, Airport ukAirport, List<Passenger> emptyPassengers) {
        System.out.println("Please select a destination for the flight from the list below:");
        Stream.of(Destination.values()).forEach(System.out::println);
        Destination flightDest = Destination.valueOf(in.next().toUpperCase());
        boolean loop = true;
        int flightID = 0;
        while (loop) {
            System.out.println("Please provide an ID number: ");
            //if they don't pick a number (done)
            try {
                flightID = in.nextInt();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Please provide a valid flight ID number: ");
                in.next();
            }
        }
        ukAirport.addFlight(flightDest, flightID);

    }

    public static void displayFlights(Scanner in, Airport ukAirport, List<Passenger> emptyPassengers) {
        ukAirport.getAllFlights()
                .forEach(flight -> System.out.println(flight.getDestination()
                        + ", Flight number "
                        + flight.getFlightId()));
    }

    public static void addPassenger(Scanner in, List<Passenger> emptyPassengers) {
        //exception if they don't provide a string for a name/email/last name Michelle
        System.out.println("Please provide a first name: ");
        String firstName = null;
        String lastName = null;
        String email = null;
        int passportID = 0;
        boolean loop = true;
        while (loop) {
            try {
                firstName = in.next().toLowerCase();
            } catch (InputMismatchException e) {
                System.out.println("Please provide a valid name: ");
                continue;
            }
            System.out.println("Please provide a last name: ");

            try {
                lastName = in.next().toLowerCase();
            } catch (InputMismatchException e) {
                System.out.println("Please provide a valid name: ");
            }

            System.out.println("Please provide an email address: ");
            try {
                email = in.next();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Please provide a valid email address: ");
            }
            System.out.println("Finally, please provide your passport number: ");
//        exception if they provide a string instead of int Michelle
            passportID = in.nextInt();
        }
        Passenger newPassenger = new Passenger(firstName, lastName, email, passportID);
        emptyPassengers.add(newPassenger);
        System.out.println("Passenger " + firstName + " " + lastName + " has been added.");

    }

    public static void bookAPassenger(Scanner in, Airport ukAirport, List<Passenger> emptyPassengers) {
        //Provide passenger id
        System.out.println("Please provide a passport number: ");
        //exception if not a number
        int passengerId = in.nextInt();
        //Find correct passenger
        Passenger passengerToAdd;
        try {
            passengerToAdd = emptyPassengers.stream().filter(p -> p.getPassportID() == passengerId).toList().get(0);
        }
        catch(Exception e){
            passengerToAdd = passengerNotFound(in);
        }

        System.out.println("You have chosen passenger: " + passengerToAdd.getFirstName() + " " + passengerToAdd.getLastName());
        //Provide flight ID
        //Find correct flight
//        exception if the flight is not found
        Flight flightToAdd = null;
        String msg;
        boolean loop = true;
        while(loop) {
            System.out.println("Please provide the flight ID to book on to: ");
            int flightId = in.nextInt();
            try {
                int finalFlightId = flightId;
                flightToAdd = ukAirport.getAllFlights().stream().filter(f -> f.getFlightId() == finalFlightId).toList().get(0);
                loop = false;
            } catch (Exception e) {
                msg = "Flight not found! Try Again";
//            throw new RuntimeException(e);
                System.out.println("Please provide the flight ID to book on to: ");
                flightId = in.nextInt();
            }
        }
        System.out.println("You have chosen Flight number: " + flightToAdd.getFlightId() + ", to " + flightToAdd.getDestination());
        //Add passenger to flight
        flightToAdd.addPassenger(passengerToAdd);
        System.out.println("Passenger has been added, thank you :)");
    }

    public static void cancelAnExistingFlight(Scanner in, Airport ukAirport, List<Passenger> emptyPassengers) {
        int num = 0;
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("Please select the flight you wish to cancel");
                int flightNumber = in.nextInt();
//                exception if they pick a flight not created
                Destination flightDest = ukAirport.getAllFlights().stream().filter(f -> f.getFlightId() == flightNumber).map(f -> f.getDestination()).toList().get(0);
                System.out.println("You have selected " + flightNumber + " going to " + flightDest + ". If this is correct, enter 1. If not, enter 2");
                    num = in.nextInt();
                if (num == 1) {
//              find flight number
                    Flight flightToRemove = ukAirport.getAllFlights().stream().filter(f -> f.getFlightId() == flightNumber).toList().get(0);
//               remove flight method
                    ukAirport.removeFlight(flightToRemove);
                    System.out.println("The flight " + flightNumber + " has been canceled. Thank you");
                    loop = false;
                }
                if (num == 2) {
                    System.out.println("Please retry");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    public static Passenger passengerNotFound(Scanner in){
        System.out.println("Passenger does not exist, please create a new passenger:");
        System.out.println("Please provide a first name: ");
        String firstName = in.next().toLowerCase();
        System.out.println("Please provide a last name: ");
        String lastName = in.next().toLowerCase();
        System.out.println("Please provide an email address: ");
        String email = in.next();
        System.out.println("Finally, please provide a passport number: ");
        int passportID = in.nextInt();
        Passenger newPassenger = new Passenger(firstName, lastName, email, passportID);
        return newPassenger;
    }

}
