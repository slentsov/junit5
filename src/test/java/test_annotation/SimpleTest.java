package test_annotation;

import exception.BackToTheFutureException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.DateServiceImpl;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofNanos;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

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
    public void testGetRandomDateWithException() {
        int period = 0;
        assertThrows(BackToTheFutureException.class, () -> new DateServiceImpl().getRandomDate(null, period));
    }

    @Test
    @DisplayName("Test with timeout")
    public void testGetRandomDateWithTimeout() {
        int period = 30;
        assertTimeout(ofMillis(1), () -> new DateServiceImpl().getRandomDate(presentTime, period));
    }

    @Test
    @DisplayName("Test with preemptive timeout")
    public void testGetRandomDateWithPreemptiveTimeout() {
        int period = 30;
        assertTimeoutPreemptively(ofNanos(1), () -> new DateServiceImpl().getRandomDate(presentTime, period));
    }
}