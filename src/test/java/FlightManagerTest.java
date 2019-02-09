import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    FlightManager flightManager;
    Flight flight;
    Passenger passenger;
    Flight flight2;


    @Before
    public void before(){
        flightManager = new FlightManager();
        flight = new Flight(2001, "Glasgow", "London" , "20:00", PlaneType.CESNA);
        flight2 = new Flight(2001, "Glasgow", "London" , "20:00", PlaneType.BOEING737);
        passenger = new Passenger("Steven Smith", 2);
        flight.addPassenger(passenger);


    }

    @Test
    public void canGetEmptyPlaneBaggageWeightAvailable(){
        int weightAvailable = flightManager.totalEmptyBaggageWeight(flight);
        assertEquals(40, weightAvailable);
    }

    @Test
    public void howMuchWeightIsReservedPerPassenger(){
        int passengerBaggage = flightManager.calculatePassengerBaggageAllowance(flight);
        assertEquals(20, passengerBaggage);
    }

    @Test
    public void howMuchHasBeenReservedByPassengers(){
        int reservedWeight = flightManager.calculateReservedBaggageWeight(flight);
        assertEquals(20, reservedWeight);
    }

    @Test
    public void howMuchBaggaeWeightRemains(){
        int weightRemaining = flightManager.calculateBaggageWeightRemaining(flight);
        assertEquals(20, weightRemaining);
    }

    @Test
    public void canMakeBookings(){
        flightManager.makeBooking(flight, passenger);
        assertEquals(2, flight.passengerCount());
        assertEquals(flight, passenger.getFlight());
    }

    @Test
    public void isSeatAvailable(){
        
    }
}
