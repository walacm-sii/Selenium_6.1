package tests.widgets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.widgets.component.DatePickerComponent;
import tests.widgets.component.DateUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DatePicker extends BaseTest {
    private String DATE_PICKER_URL = "http://www.seleniumui.moderntester.pl/datepicker.php";
    private DatePickerComponent datePickerComponent;

    @BeforeEach
    public void testSetup() {
        datePickerComponent = new DatePickerComponent(driver);
    }

    @Test
    public void datePicker() {
        driver.get(DATE_PICKER_URL);

        LocalDate today = DateUtil.getToday();
        datePickerComponent.selectDate(today);
        assertThat(parseString(datePickerComponent.getDatePickerCurrentDate())).isEqualTo(today);

        LocalDate firstDayOfTheNextMonth = DateUtil.getFirstDayOfTheNextMonth();
        datePickerComponent.selectDate(firstDayOfTheNextMonth);
        assertThat(parseString(datePickerComponent.getDatePickerCurrentDate())).isEqualTo(firstDayOfTheNextMonth);

        LocalDate lastDayOfJanuaryInNextYear = DateUtil.getLastDayOfJanuaryInNextYear();
        datePickerComponent.selectDate(lastDayOfJanuaryInNextYear);
        assertThat(parseString(datePickerComponent.getDatePickerCurrentDate())).isEqualTo(lastDayOfJanuaryInNextYear);

        datePickerComponent.selectDate(lastDayOfJanuaryInNextYear);
        assertThat(parseString(datePickerComponent.getDatePickerCurrentDate())).isEqualTo(lastDayOfJanuaryInNextYear);

        LocalDate randomDayFromPreviousMonth = DateUtil.getRandomDayFromPreviousMonth();
        datePickerComponent.selectDate(randomDayFromPreviousMonth);
        assertThat(parseString(datePickerComponent.getDatePickerCurrentDate())).isEqualTo(randomDayFromPreviousMonth);

        LocalDate randomDateFromLastYear = DateUtil.getRandomDateFromLastYear();
        datePickerComponent.selectDate(randomDateFromLastYear);
        assertThat(parseString(datePickerComponent.getDatePickerCurrentDate())).isEqualTo(randomDateFromLastYear);
    }

    public LocalDate parseString(String date) {
        List<Integer> splitted = Arrays.stream(date.split("/")).map(Integer::parseInt).toList();
        return LocalDate.of(splitted.get(2), splitted.get(0), splitted.get(1));
    }
}
