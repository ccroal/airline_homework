import java.util.ArrayList;
import java.util.Date;

public class Flight {

    private int flightNumber;
    private ArrayList<Passenger> passengers;
    private String destination;
    private String departureLocation;
    private String departureTime;
    private PlaneType plane;

    public Flight(int flightNumber, String destination, String departureLocation, String departureTime, PlaneType plane) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureLocation = departureLocation;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<Passenger>();
        this.plane = plane;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Passenger getPassenger(int index){
        return this.passengers.get(index);
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public PlaneType getPlane() {
        return plane;
    }

    public int passengerCount() {
        return this.passengers.size();
    }


    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public int flightCapacity(){
        return this.plane.getCapacity();
    }

    public int findEmptySeats() {
        int emptySeats = flightCapacity() - passengerCount();
        return emptySeats;
    }

    public boolean checkSpaceAvailable(){
        if (findEmptySeats() >= passengerCount()) {
            return true;
        }
        return false;
    }

    public void bookPassenger(Passenger passenger){
        if (checkSpaceAvailable()){
            this.addPassenger(passenger);
        }
    }




}
