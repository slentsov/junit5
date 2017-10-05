package nested_annotation;

import exception.BackToTheFutureException;
import org.junit.jupiter.api.*;
import services.DateServiceImpl;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("When Marty tried to type proper date")
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
    @DisplayName("he was fast enough to do this")
    void testGetRandomDateWithProperTime() {
        int period = 0;
        assertTimeout(Duration.ofMillis(2), () -> new DateServiceImpl().getRandomDate(presentTime, period));
    }

    @Nested
    @DisplayName("he made a mistake")
    class InnerTest {
        @Test
        @DisplayName("he put an invalid date")
        @Tag("Exception")
        public void testGetRandomDateWithException() {
            int period = 0;
            assertThrows(BackToTheFutureException.class, () -> new DateServiceImpl().getRandomDate(null, period));
        }
    }
}