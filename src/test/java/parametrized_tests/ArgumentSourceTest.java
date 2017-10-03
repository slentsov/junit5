package parametrized_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import parametrized_tests.util.DateArgumentsProvider;
import services.DateServiceImpl;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class ArgumentSourceTest {

    @DisplayName("Bunch of tests related to DateArgumentsProvider")
    @ParameterizedTest(name = "Test number {index} with argument provided by DateArgumentProvider. Argument is {arguments}")
    @ArgumentsSource(DateArgumentsProvider.class)
    void testGetRandomDateNobodyCaresWithWhatDates(Calendar date) {
        assertNotEquals(new DateServiceImpl().getRandomDate(date, 30), date);
    }
}
