package parametrized_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import parametrized_tests.util.MovieHero;
import parametrized_tests.util.HeroesConverter;

import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

@DisplayName("Test that represents the CSV source")
public class CsvSourceTest {

    @ParameterizedTest
    @CsvSource({"Marty, 1", "Doc, 2", "Max, 3"})
    void testMainRole(String name, int position) {
        assertTrue("It is not main hero's name", "Marty".equals(name) || "Doc".equals(name));
        assertTrue("It is not main hero's position", position < 3);
    }

    @ParameterizedTest
    @CsvSource({"Marty", "Doc", "Max"})
    void testMainRole(@ConvertWith(HeroesConverter.class) MovieHero hero) {
        assertTrue("It is not main hero's name", hero != null);
    }
}
