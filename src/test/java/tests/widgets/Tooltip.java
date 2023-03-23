package tests.widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class Tooltip extends BaseTest {

    private String TOOLTIP_URL = "http://www.seleniumui.moderntester.pl/tooltip.php";

    @Test
    public void tooltip() {
        driver.get(TOOLTIP_URL);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("age"))).perform();

        String tooltipMessage = driver.findElement(By.cssSelector("[role='tooltip']")).getText();

        assertThat(tooltipMessage).isEqualTo("We ask for your age only for statistical purposes.");
    }
}
