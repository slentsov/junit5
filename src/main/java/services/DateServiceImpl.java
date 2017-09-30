package services;

import exception.BackToTheFutureException;

import java.util.Calendar;

public class DateServiceImpl implements DateService {


    public Calendar getRandomDate(Calendar initialCalendar, int period) throws BackToTheFutureException {

        validateDate(initialCalendar);

        initialCalendar.add(Calendar.YEAR, period);
        long leftLimit = initialCalendar.getTimeInMillis();

        initialCalendar.add(Calendar.YEAR, -period * 2);
        long rightLimit = initialCalendar.getTimeInMillis();

        Calendar resultCalendar = Calendar.getInstance();
        resultCalendar.setTimeInMillis(leftLimit + (long) (Math.random() * (rightLimit - leftLimit)));

        return resultCalendar;
    }

    private static void validateDate(Calendar calendar) {
        if (calendar == null) {
            throw new BackToTheFutureException();
        }
    }

}
