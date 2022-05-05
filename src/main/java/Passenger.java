public class Passenger {

    private String firstName;
    private String lastName;
    private String email;
    private int passportID;

    public Passenger(String firstName, String lastName, String email, int passportID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passportID = passportID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassportID() {
        return passportID;
    }

    public void setPassportID(int passportID) {
        this.passportID = passportID;
    }

    @Override
    public String toString() {
        return "passenger{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passportID=" + passportID +
                '}';
    }


}
