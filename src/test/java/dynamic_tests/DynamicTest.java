package dynamic_tests;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@DisplayName("Dynamic test in action")
public class DynamicTest {

    private static final int PRESENT_YEAR = 1985;
    private static final int PRESENT_MONTH = 11;
    private static final int PRESENT_DAY = 12;
    private static Calendar presentTime;

    @BeforeEach
    public void prepareDate() {
        presentTime = Calendar.getInstance();
        presentTime.set(PRESENT_YEAR, PRESENT_MONTH, PRESENT_DAY);
    }

    @TestFactory
    @DisplayName("test factory with collection of dynamic tests")
    Collection<org.junit.jupiter.api.DynamicTest> testEverythingCollection() {
        return Arrays.asList(
                    dynamicTest("The first test", () -> assertTrue(true)),
                    dynamicTest("The second test", () -> assertFalse(false)));
    }

    @TestFactory
    @DisplayName("test factory with collection of dynamic tests")
    Stream<org.junit.jupiter.api.DynamicTest> testEverythingStream() {
        return IntStream.iterate(3, previous -> previous + 1)
                .limit(97)
                .mapToObj(number -> dynamicTest("Test number " + number, () -> assertTrue(true)));
    }

    @TestFactory
    @DisplayName("test factory with collection of dynamic nodes")
    Stream<DynamicNode> dynamicTestsWithContainers() {
        return Stream.of("A", "B", "C")
                .map(input -> dynamicContainer("Container " + input, Stream.of(
                        dynamicTest("not null", () -> assertNotNull(input)),
                        dynamicContainer("properties", Stream.of(
                                dynamicTest("length > 0", () -> assertTrue(input.length() > 0)),
                                dynamicTest("not empty", () -> assertFalse(input.isEmpty()))
                        ))
                )));
    }
}
