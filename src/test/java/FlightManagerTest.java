import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    FlightManager flightManager;
    Flight flight;
    Passenger passenger;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    Passenger passenger5;
    Flight flight2;


    @Before
    public void before(){
        flightManager = new FlightManager();
        flight = new Flight(2001, "Glasgow", "London" , "20:00", PlaneType.CESNA);
        flight2 = new Flight(2001, "Glasgow", "London" , "20:00", PlaneType.BOEING737);
        passenger = new Passenger("Steven Smith", 2);
        passenger2 = new Passenger("Steven Smith", 2);
        passenger3 = new Passenger("Steven Smith", 2);
        passenger4 = new Passenger("Steven Smith", 2);
        passenger5 = new Passenger("Steven Smith", 2);
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
    public void howMuchBaggageWeightRemains(){
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
        assertEquals(true, flightManager.checkSeatAvailable(flight2, 2));
    }

//    @Test
//    public void checkSeatNotAvailable(){
//        flightManager.makeBooking(flight2, passenger);
//        flightManager.makeBooking(flight2, passenger);
//        assertEquals(false, flightManager.checkSeatAvailable(flight, 1));
//
//    }

    @Test
    public void checkSortBySeatNumber(){
        passenger.addFlight(flight2, 200);
        passenger2.addFlight(flight2, 10);
        passenger3.addFlight(flight2, 289);
        passenger4.addFlight(flight2, 175);
        passenger5.addFlight(flight2, 67);
        flight2.addPassenger(passenger);
        flight2.addPassenger(passenger2);
        flight2.addPassenger(passenger3);
        flight2.addPassenger(passenger4);
        flight2.addPassenger(passenger5);
        flightManager.sortBySeatNumber(flight2);
        ArrayList<Passenger> result = new ArrayList<Passenger>();
        result.add(passenger2);
        result.add(passenger5);
        result.add(passenger4);
        result.add(passenger);
        result.add(passenger3);
        assertEquals(result, flight2.getPassengers());
    }

    @Test
    public void checkFindBySeatNumber(){
        passenger.addFlight(flight2, 200);
        passenger2.addFlight(flight2, 10);
        flight2.addPassenger(passenger);
        flight2.addPassenger(passenger2);
        Passenger foundPassenger = flightManager.findPassengerBySeat(flight2,10);
        assertEquals(passenger2, foundPassenger);
    }
}
