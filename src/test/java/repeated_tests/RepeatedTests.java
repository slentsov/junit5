package repeated_tests;


import org.junit.jupiter.api.*;
import services.DateService;
import services.DateServiceImpl;

import java.util.Calendar;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@DisplayName("Test that will show repeat feature")
public class RepeatedTests {

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
    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    Stream<DynamicNode> testRepeatedTenTimes() {
        return IntStream.generate(() -> (int)(Math.random()*1000))
                .limit(5)
                .mapToObj(number -> dynamicContainer("Test with postive period " + number,
                        Stream.of(
                                dynamicTest("regular period", () -> assertNotEquals(new DateServiceImpl().getRandomDate(presentTime, number), presentTime)),
                                dynamicTest("2x period", () -> assertNotEquals(new DateServiceImpl().getRandomDate(presentTime, number * 2), presentTime)),
                                dynamicTest("5x period", () -> assertNotEquals(new DateServiceImpl().getRandomDate(presentTime, number * 5), presentTime)))));
    }

    @RepeatedTest(value = 10, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    void testRepeatedTenTimesOneTest() {
        assertNotEquals(new DateServiceImpl().getRandomDate(presentTime, 5), presentTime);
    }
}
