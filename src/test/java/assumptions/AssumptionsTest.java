package assumptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import parametrized_tests.util.MovieHero;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayName("Tests of assumptions")
public class AssumptionsTest {

    @Test
    void testTrueMartyAssumption() {
        assumeTrue("Marty".equals("Doc"), () -> "Marty is not Doc");
    }

    @Test
    void testTrueDocAssumption() {
        assumeTrue(() -> "Doc".equals("Doc"));
    }

    @Test
    @ParameterizedTest
    @ValueSource(strings ={"Marty", "Doc", "Rock"})
    void testTrueDocAssumption(String heroName) {
        assumingThat(Arrays.stream(MovieHero.values())
                .anyMatch(hero -> hero.name().equals(heroName.toUpperCase())),
                () -> assertTrue(heroName.equals("Doc"), () -> "It is not doc"));
    }
}
