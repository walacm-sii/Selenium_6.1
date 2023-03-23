package tests.widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Autocomplete extends BaseTest {

    private String AUTOCOMPLETE_URL = "http://www.seleniumui.moderntester.pl/autocomplete.php";

    @Test
    public void autocomplete() {
        driver.get(AUTOCOMPLETE_URL);
        driver.findElement(By.id("search")).sendKeys("a");
        List<WebElement> elements = driver.findElements(By.cssSelector("#ui-id-1 > li"));

        WebElement pickedElement = elements.get(new Random().nextInt(elements.size()));
        String expectedText = pickedElement.getText();
        pickedElement.click();

        assertThat(driver.findElement(By.id("search")).getAttribute("value")).isEqualTo(expectedText);
    }
}
