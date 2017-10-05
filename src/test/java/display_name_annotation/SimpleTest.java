package display_name_annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.DateServiceImpl;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        assertNotEquals(presentTime, new DateServiceImpl().getRandomDate(presentTime, period), "It's not our time Marty");
    }

    @Test
    @DisplayName("Test getRandom method with zero period")
    public void testGetRandomDateWithZeroPeriod() {
        Calendar presentTime = Calendar.getInstance();
        presentTime.set(PRESENT_YEAR, PRESENT_MONTH, PRESENT_DAY);
        int period = 0;
        assertEquals(presentTime, new DateServiceImpl().getRandomDate(presentTime, period), "It's not our time Marty");
    }
}