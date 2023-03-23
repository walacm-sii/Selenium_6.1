package tests.widgets.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatePickerComponent {


    private WebDriver driver;

    public DatePickerComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "datepicker")
    private WebElement datePickerField;

    public String getDatePickerCurrentDate() {
        return datePickerField.getAttribute("value");
    }

    public void selectDate(LocalDate localDate) {
        clickDatePickerField();
        changeCurrentMonth(localDate);
        selectDay(localDate);
    }

    public void clickDatePickerField() {
        datePickerField.click();
    }

    public void selectDay(LocalDate localDate) {
        String xpathSelector = String.format("//*[@data-month='%d']/a[contains(text(), '%d')]",
                localDate.getMonth().getValue() - 1, localDate.getDayOfMonth());
        driver.findElement(By.xpath(xpathSelector)).click();
    }

    public void changeCurrentMonth(LocalDate localDate) {
        YearMonth yM = parseLocalDateToYearMonth(localDate);

        while (true) {
            var comparator = yM.compareTo(getCurrentMonthYear());
            if (comparator > 0) {
                clickNextArrow();
            } else if (comparator < 0) {
                clickPrevArrow();
            } else {
                break;
            }
        }
    }

    private void clickNextArrow() {
        driver.findElement(By.cssSelector("[data-handler='next'] > *")).click();
    }

    private void clickPrevArrow() {
        driver.findElement(By.cssSelector("[data-handler='prev'] > *")).click();
    }

    private YearMonth parseLocalDateToYearMonth(LocalDate localDate) {
        return YearMonth.of(localDate.getYear(), localDate.getMonth());
    }

    private YearMonth getCurrentMonthYear() {
        int currentYear = Integer.parseInt(waitForCurrentYearToLoad());
        String monthString = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
        int currentMonth = parseMonth(monthString);
        return YearMonth.of(currentYear, currentMonth + 1);
    }

    private String waitForCurrentYearToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(driver -> !driver.findElement(By.cssSelector(".ui-datepicker-year")).getText().isEmpty());
        return driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
    }

    private int parseMonth(String month) {
        try {
            Date date = new SimpleDateFormat("MMMMM", Locale.ENGLISH).parse(month);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal.get(Calendar.MONTH);
        } catch (Exception e) {
            return 0;
        }
    }
}
