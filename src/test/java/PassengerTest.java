import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Steven Smith", 2);
    }

    @Test
    public void passengerHasName() {
        assertEquals("Steven Smith", passenger.getName());
    }

    @Test
    public void canGetPassengerNumberOfBags(){
        assertEquals(2, passenger.getNumberOfBags());
    }
}
