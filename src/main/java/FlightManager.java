import java.util.Random;

public class FlightManager {

    public FlightManager() {
    }


    public int totalEmptyBaggageWeight(Flight flight) {
        int emptyBaggageWeight = flight.getPlane().getWeight() / 2;
        return emptyBaggageWeight;
    }

    public int calculatePassengerBaggageAllowance(Flight flight) {
        int baggageAllowance = totalEmptyBaggageWeight(flight)/ flight.getPlane().getCapacity();
        return baggageAllowance;
    }


    public int calculateReservedBaggageWeight(Flight flight) {
        int bagWeight = 10;
        int passengerBaggageWeight = 0;
        for(Passenger passenger: flight.getPassengers()){
            passengerBaggageWeight += passenger.numberOfBags * bagWeight;
        }
        return passengerBaggageWeight;
    }

    public int calculateBaggageWeightRemaining(Flight flight) {
        int weightRemaining = totalEmptyBaggageWeight(flight) - calculateReservedBaggageWeight(flight);
        return weightRemaining;
    }


    public void makeBooking(Flight flight, Passenger passenger) {
        flight.bookPassenger(passenger);
        int seatNumber = generateSeatnumber(flight);
        passenger.addFlight(flight, seatNumber);
    }

    public int generateSeatnumber(Flight flight){
        int capacity = flight.flightCapacity();
        Random seatGenerator = new Random();
        int seatNumber = seatGenerator.nextInt(capacity) + 1;
        return seatNumber;
    }

    public boolean checkSeatAvailable(Flight flight, int seatNumber){
        for(Passenger passenger: flight.getPassengers()){
            if (seatNumber == passenger.getSeatNumber(){
                return false;
            }
        }
    }
}
