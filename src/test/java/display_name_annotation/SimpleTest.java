package display_name_annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.DateServiceImpl;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
@DisplayName("Tests that include pretty naming")
public class SimpleTest {

    private static final int PRESENT_YEAR = 1985;
    private static final int PRESENT_MONTH = 11;
    private static final int PRESENT_DAY = 12;

    @Test
    @DisplayName("Test getRandom method with big period (not equal to zero)")
    public void testGetRandomDateWithNotZeroPeriod() {
        Calendar presentTime = Calendar.getInstance();
        presentTime.set(PRESENT_YEAR, PRESENT_MONTH, PRESENT_DAY);
        int period = 30;
        assertNotEquals("It's not a our time Marty", new DateServiceImpl().getRandomDate(presentTime, period), presentTime);
    }

    @Test
    @DisplayName("Test getRandom method with zero period")
    public void testGetRandomDateWithZeroPeriod() {
        Calendar presentTime = Calendar.getInstance();
        presentTime.set(PRESENT_YEAR, PRESENT_MONTH, PRESENT_DAY);
        int period = 0;
        assertEquals("It's not a our time Marty", new DateServiceImpl().getRandomDate(presentTime, period), presentTime);
    }
}