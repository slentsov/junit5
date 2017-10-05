package parametrized_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test devoted to csv sources")
public class CsvFileSourceTest {

    @DisplayName("Tests with using csv file with only period inside")
    @ParameterizedTest(name = "{index}    ----->     argument from the csv file: {arguments}")
    @CsvFileSource(resources = "/backToTheFutureWithPeriod.csv")
    void testArgumentProvidedByCsvFileSource(int period) {
        assertAll(() -> assertEquals(period, 5, "The period is invalid"));
    }

    @DisplayName("Tests with using csv file with period and heroicTxt inside")
    @ParameterizedTest
    @CsvFileSource(resources = "/backToTheFutureWithPeriodAndHeroicText.csv")
    void testArgumentsProvidedByCsvFileSource(int period, String heroicText) {
        assertAll(
                () -> assertEquals(period, 4, "The period is invalid"),
                () -> assertEquals(heroicText, "Mmmm...?", "The text is invalid"),
                () -> {
                    assertEquals(period, 4, "The period is invalid");
                    assertEquals(heroicText, "Mmmm...?", "The text is invalid");
                });
    }
}
