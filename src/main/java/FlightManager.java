import java.util.ArrayList;
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
        int seatNumber = generateSeatnumber(flight);
        if(checkSeatAvailable(flight, seatNumber)) {
            passenger.addFlight(flight, seatNumber);
            flight.bookPassenger(passenger);
        }else{
            makeBooking(flight, passenger);
        }
    }

    public int generateSeatnumber(Flight flight){
        int capacity = flight.flightCapacity();
        Random seatGenerator = new Random();
        int seatNumber = seatGenerator.nextInt(capacity) + 1;
        return seatNumber;
    }

    public boolean checkSeatAvailable(Flight flight, int seatNumber){
        if (flight.passengerCount() > 0) {
            for (Passenger passenger : flight.getPassengers()) {
                if (seatNumber == passenger.getSeatNumber()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void sortBySeatNumber(Flight flight){

        int numberOfPassengers = flight.passengerCount();

        Passenger temp;
        Passenger temp2;

        for (int i = 0; i < numberOfPassengers; i++) {
            for (int j = 0; j < numberOfPassengers - i - 1; j++) {
                if (flight.getPassenger(j).getSeatNumber() > flight.getPassenger(j + 1).getSeatNumber()) {
                    temp = flight.getPassenger(j+1);
                    temp2 = flight.getPassenger(j);
                    flight.getPassengers().set(j, temp);
                    flight.getPassengers().set(j+1, temp2);

                }
            }
        }
    }

    public Passenger findPassengerBySeat(Flight flight, int seatNumber) {
        sortBySeatNumber(flight);

        int start = 0;
        int end = flight.passengerCount() - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if ()
        }
    }
}
