package parametrized_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import services.DateServiceImpl;

import java.util.Calendar;
import java.util.Random;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("Test that uses methods as source of arguments for tests")
public class MethodSourceTest {

    @ParameterizedTest(name = "{index} --- date that was used is {arguments} ")
    @MethodSource("timeProvider")
    @DisplayName("tests with one argument")
    void testMethodSource(Calendar date) {
        assertNotEquals(new DateServiceImpl().getRandomDate(date, 30), date);
    }

    @ParameterizedTest(name = "{index} --- date that was used is {0} and period is {1} ")
    @MethodSource("timeProvider")
    @DisplayName("tests with two arguments")
    void testMethodSourceWithFewArguments(Calendar date, int period) {
        assertNotEquals(new DateServiceImpl().getRandomDate(date, 30), period);
    }

    static Stream<Arguments> timeProvider() {
        return LongStream
                .iterate(Calendar.getInstance().getTimeInMillis(), previousItem -> previousItem + new Random().nextLong())
                .limit(50)
                .mapToObj(dateInMillis -> {
                    Calendar date = Calendar.getInstance();
                    date.setTimeInMillis(dateInMillis);
                    return date;
                })
                .map(date -> Arguments.of(date, periodProvider()));
    }

    static int periodProvider() {
        return (int) (Math.random() * 1_000_000 > 500_000 ? (Math.random() * 10000) : (-Math.random() * 10000));
    }

}
