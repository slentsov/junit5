package parametrized_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Test devoted to csv sources")
public class CsvFileSourceTest {

    @DisplayName("Tests with using csv file with only period inside")
    @ParameterizedTest(name = "{index}    ----->     argument from the csv file: {arguments}")
    @CsvFileSource(resources = "/backToTheFutureWithPeriod.csv")
    void testArgumentProvidedByCsvFileSource(int period) {
        assertAll(() -> assertEquals("The period is invalid", 5, period));
    }

    @DisplayName("Tests with using csv file with period and heroicTxt inside")
    @ParameterizedTest
    @CsvFileSource(resources = "/backToTheFutureWithPeriodAndHeroicText.csv")
    void testArgumentsProvidedByCsvFileSource(int period, String heroicText) {
        assertAll(
                () -> assertEquals("The period is invalid", 4, period),
                () -> assertEquals("The text is invalid", "Mmmm...?", heroicText),
                () -> {
                    assertEquals("The period is invalid", 4, period);
                    assertEquals("The text is invalid", "Mmmm...?", heroicText);
                });
    }
}
