package tests.interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Selectable extends BaseTest {

    private String SELECTABLE_URL = "http://www.seleniumui.moderntester.pl/selectable.php";

    @Test
    public void selectable() {
        driver.get(SELECTABLE_URL);
        Actions actions = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.cssSelector("#selectable > li"));

        actions.keyDown(Keys.LEFT_CONTROL)
                .click(elements.get(0))
                .click(elements.get(2))
                .click(elements.get(3))
                .perform();

        assertThat(driver.findElement(By.id("select-result")).getText()).isEqualTo("#1 #3 #4");
    }
}
