import java.util.ArrayList;

public class Passenger {

    String name;
    int numberOfBags;
    ArrayList<Flight> flight;
    int seatNumber;

    public Passenger(String name, int numberOfBags) {
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.flight = new ArrayList<Flight>();
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfBags() {
        return this.numberOfBags;
    }


    public Object getFlight() {
        return this.flight.get(0);
    }

    public void addFlight(Flight flight, int seatNumber) {
        this.flight.add(flight);
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber(){
        return this.seatNumber;
    }

    public int setSeatNumber(int seatNumber){
        return this.seatNumber = seatNumber;
    }
}
