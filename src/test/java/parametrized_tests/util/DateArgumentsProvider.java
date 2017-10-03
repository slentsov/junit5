package parametrized_tests.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Calendar;
import java.util.Random;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class DateArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return LongStream
                .iterate(Calendar.getInstance().getTimeInMillis(), previousItem -> previousItem + new Random().nextLong())
                .limit(50)
                .mapToObj(dateInMillis -> {
                    Calendar date = Calendar.getInstance();
                    date.setTimeInMillis(dateInMillis);
                    return date;
                })
                .map(Arguments::of);
    }
}
