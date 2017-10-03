package parametrized_tests.util;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class HeroesConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
        try {
            if (o instanceof String) {
                return MovieHero.valueOf(String.valueOf(o).toUpperCase());
            }
            throw new ArgumentConversionException("Unknown parameter: " + o);
        } catch (IllegalArgumentException e) {
            throw new ArgumentConversionException("Unknown parameter: " + o);
        }
    }
}
