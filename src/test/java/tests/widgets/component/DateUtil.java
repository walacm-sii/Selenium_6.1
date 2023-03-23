package tests.widgets.component;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Random;

public class DateUtil {
    public static LocalDate getRandomDateFromLastYear() {
        return LocalDate.now().plusYears(-1)
                .withDayOfYear(new Random().nextInt(YearMonth.now().plusYears(-1).lengthOfYear()) + 1);
    }

    public static LocalDate getRandomDayFromPreviousMonth() {
        return LocalDate.now().plusMonths(-1)
                .withDayOfMonth(new Random().nextInt(YearMonth.now().plusMonths(-1).atEndOfMonth().getDayOfMonth()) + 1);
    }

    public static LocalDate getLastDayOfJanuaryInNextYear() {
        return YearMonth.now().withYear(YearMonth.now().plusYears(1).getYear())
                .withMonth(1).atEndOfMonth();
    }

    public static LocalDate getFirstDayOfTheNextMonth() {
        return YearMonth.now().plusMonths(1).atDay(1);
    }

    public static LocalDate getToday() {
        return LocalDate.now();
    }
}
