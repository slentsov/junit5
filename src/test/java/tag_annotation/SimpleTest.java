package tag_annotation;

import exception.BackToTheFutureException;
import org.junit.jupiter.api.*;
import services.DateServiceImpl;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests with tags")
public class SimpleTest {

    private static final int PRESENT_YEAR = 1985;
    private static final int PRESENT_MONTH = 11;
    private static final int PRESENT_DAY = 12;
    private static Calendar presentTime;

    @BeforeEach
    public void prepareDate() {
        presentTime = Calendar.getInstance();
        presentTime.set(PRESENT_YEAR, PRESENT_MONTH, PRESENT_DAY);
    }

    @Test
    @DisplayName("Test with exception expectation")
    @Tag("Exception")
    public void testGetRandomDateWithException() {
        int period = 0;
        assertThrows(BackToTheFutureException.class, () -> new DateServiceImpl().getRandomDate(null, period));
    }

    @Test
    @DisplayName("Test with timeout")
    @Tag("Timeout")
    public void testGetRandomDateWithTimeout() {
        int period = 30;
        assertTimeout(Duration.of(2, ChronoUnit.MILLIS), () -> new DateServiceImpl().getRandomDate(presentTime, period));
    }

    @Test
    @DisplayName("Test with preemptive timeout")
    @Tag("Timeout")
    public void testGetRandomDateWithPreemptiveTimeout() {
        int period = 30;
        assertTimeoutPreemptively(Duration.of(1, ChronoUnit.MICROS), () -> new DateServiceImpl().getRandomDate(presentTime, period));
    }
}