package parametrized_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Test that uses values as source of arguments for tests")
//Only one argument might be passed with this annotation
public class ValueSourceTest {

    @ParameterizedTest(name = "{index}  ----->   string value {arguments}")
    @DisplayName("use Strings as arguments")
    @ValueSource(strings = {"Marty", "Doc", ""})
    void testValueSourceAnnotation(String value) {
        assertNotNull(value, () -> "provided value was null");
    }

    @ParameterizedTest(name = "{index}  ----->   double value {arguments}")
    @DisplayName("use doubles as arguments")
    @ValueSource(doubles = {1, 2.0, 0.5})
    void testValueSourceAnnotation(double value) {
        assertNotNull(value, () -> "provided value was null");
    }

}
