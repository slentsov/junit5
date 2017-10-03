package parametrized_tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import parametrized_tests.util.MovieHero;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.params.provider.EnumSource.Mode.EXCLUDE;

public class EnumSourceTest {

    @ParameterizedTest
    @EnumSource(MovieHero.class)
    void testSpecificHeroe(MovieHero hero) {
        assertTrue("Hero is not here", hero != null);
    }

    @ParameterizedTest
    @EnumSource(value = MovieHero.class, names = {"MARTY"})
    void testSpecificHero(MovieHero hero) {
        assertTrue("Hero is not here", hero != null);
    }

    @ParameterizedTest
    @EnumSource(value = MovieHero.class, mode = EXCLUDE, names = {"MARTY"})
    void testOtherSpecificHero(MovieHero hero) {
        assertTrue("Hero is not here", hero != null);
    }
}
