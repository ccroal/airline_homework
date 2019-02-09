import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;
    Flight flight;

    @Before
    public void before() {
        passenger = new Passenger("Steven Smith", 2);
        flight = new Flight(2001, "Glasgow", "London" , "20:00", PlaneType.CESNA);
    }

    @Test
    public void passengerHasName() {
        assertEquals("Steven Smith", passenger.getName());
    }

    @Test
    public void canGetPassengerNumberOfBags(){
        assertEquals(2, passenger.getNumberOfBags());
    }

    @Test
    public void canAddFlight(){
        passenger.addFlight(flight, 2);
        assertEquals(flight, passenger.getFlight());
    }
}
