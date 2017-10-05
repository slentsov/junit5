package junit5;

import org.junit.jupiter.api.Test;
import services.DateServiceImpl;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class SimpleTest {

    private static final int PRESENT_YEAR = 1985;
    private static final int PRESENT_MONTH = 11;
    private static final int PRESENT_DAY = 12;

    @Test
    public void simpleJunit5Test() {
        Calendar presentTime = Calendar.getInstance();
        presentTime.set(PRESENT_YEAR, PRESENT_MONTH, PRESENT_DAY);
        int period = 30;
        assertNotEquals(presentTime, new DateServiceImpl().getRandomDate(presentTime, period), "It's not a our time Marty");
    }
}
