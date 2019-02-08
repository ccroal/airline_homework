import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Passenger passenger;

    @Before
    public void before(){
        flight = new Flight(2001, "Glasgow", "London" , "20:00", PlaneType.CESNA);
        passenger = new Passenger("Steven Smith", 2);
    }

    @Test
    public void flightHasNumber(){
        assertEquals(2001, flight.getFlightNumber());
    }

    @Test
    public void flightHasDestination(){
        assertEquals("Glasgow", flight.getDestination());
    }

    @Test
    public void flightHasDepartureLocation(){
        assertEquals("London", flight.getDepartureLocation());
    }

    @Test
    public void flightHasDepartureTime(){
        assertEquals("20:00", flight.getDepartureTime());
    }

    @Test
    public void flightHasPlane(){
        assertEquals(PlaneType.CESNA, flight.getPlane());
    }

    @Test
    public void canAddPassengers(){
        flight.addPassenger(passenger);
        assertEquals(1, flight.passengerCount());
    }

    @Test
    public void canFindEmptySeats(){
        int emptySeats = flight.findEmptySeats();
        assertEquals(2, emptySeats);
    }

    @Test
    public void canBookPassengerIfSpace(){
        flight.bookPassenger(passenger);
        assertEquals(1, flight.passengerCount());
    }

    @Test
    public void cannotOverBook(){
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger);
        assertEquals(2, flight.passengerCount());
    }
}
