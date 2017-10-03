package extensions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@DisplayName("The test that represents using of extension point")
public class ExtensionTest {

    @Test
    @ExtendWith(TimingExtension.class)
    @MethodSource("provideLongs")
    void testExtension(long pause) {
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Stream<Arguments> provideLongs() {
            return LongStream.generate(() -> new Random().nextLong())
                    .mapToObj(Arguments::of);
    }
}
