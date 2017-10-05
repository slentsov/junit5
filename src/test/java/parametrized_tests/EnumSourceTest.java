package parametrized_tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import parametrized_tests.util.MovieHero;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

public class EnumSourceTest {

    @ParameterizedTest
    @EnumSource(MovieHero.class)
    void testAllHeroes(MovieHero hero) {
        assertTrue(hero != null, "Hero is not here");
    }

    @ParameterizedTest
    @EnumSource(value = MovieHero.class, names = {"MARTY"})
    void testSpecificHero(MovieHero hero) {
        assertTrue(hero != null, "Hero is not here");
    }

    @ParameterizedTest
    @EnumSource(value = MovieHero.class, mode = EXCLUDE, names = {"MARTY"})
    void testOtherSpecificHero(MovieHero hero) {
        assertTrue(hero != null, "Hero is not here");
    }
}
