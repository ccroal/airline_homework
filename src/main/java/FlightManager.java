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


}
