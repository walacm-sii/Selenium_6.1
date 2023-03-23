package tests.interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Droppable extends BaseTest {
    private String DROPPABLE_URL = "http://www.seleniumui.moderntester.pl/droppable.php";

    @Test
    public void droppable() {
        driver.get(DROPPABLE_URL);
        Actions action = new Actions(driver);
        WebElement draggableBox = driver.findElement(By.id("draggable"));
        WebElement droppableSquare = driver.findElement(By.id("droppable"));
        action.dragAndDrop(draggableBox, droppableSquare).perform();
        assertThat(droppableSquare.getText()).isEqualTo("Dropped!");
    }
}
