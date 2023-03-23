package tests.interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Sortable extends BaseTest {

    private String SORTABLE_URL = "http://www.seleniumui.moderntester.pl/sortable.php";

    @Test
    public void sortable() {
        driver.get(SORTABLE_URL);
        List<Integer> table = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7));
        Collections.shuffle(table);

        List<WebElement> elements = actualList(driver);
        Actions actions = new Actions(driver);

        for (int i = 0; i < table.size(); i++) {
            List<WebElement> newOrder = actualList(driver);
            actions.dragAndDrop(elements.get(table.get(i) - 1), newOrder.get(i)).perform();
        }

        List<Integer> orderAfterShuffling = actualList(driver).stream()
                .map(el -> Integer.parseInt(el.getText().substring(el.getText().length() - 1))).toList();
        assertThat(orderAfterShuffling).isEqualTo(table);
    }

    private List<WebElement> actualList(WebDriver driver) {
        return driver.findElements(By.cssSelector("#sortable > li"));
    }
}
