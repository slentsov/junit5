package parametrized_tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import parametrized_tests.util.MovieHero;
import parametrized_tests.util.HeroesConverter;

import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("Test that represents the CSV source")
public class CsvSourceTest {

    @ParameterizedTest
    @CsvSource({"Marty, 1", "Doc, 2", "Max, 3"})
    @Disabled
    void testMainRole(String name, int position) {
        assertTrue("Marty".equals(name) || "Doc".equals(name), "It is not main hero's name");
        assertTrue(position < 3, "It is not main hero's position");
    }

    @ParameterizedTest
    @CsvSource({"Marty", "Doc", "Max"})
    @Disabled
    void testMainRole(@ConvertWith(HeroesConverter.class) MovieHero hero) {
        assertTrue(hero != null, "It is not main hero's name");
    }
}
