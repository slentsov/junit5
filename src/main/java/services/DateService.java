package services;

import exception.BackToTheFutureException;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertThrows;


public interface DateService {

    Calendar getRandomDate(Calendar initialCalendar, int period) throws BackToTheFutureException;

    @Test
    default void testRandomDate() {
        assertThrows(BackToTheFutureException.class, () -> getRandomDate(null, 0));
    }
}
