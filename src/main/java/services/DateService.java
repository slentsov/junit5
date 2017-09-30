package services;

import exception.BackToTheFutureException;

import java.util.Calendar;

public interface DateService {

    Calendar getRandomDate(Calendar initialCalendar, int period) throws BackToTheFutureException;
}
