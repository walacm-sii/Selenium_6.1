package tests.interactions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

public class Draggable extends BaseTest {
    private String DRAGGABLE_URL = "http://www.seleniumui.moderntester.pl/draggable.php";

    @Test
    public void draggable() {
        driver.get(DRAGGABLE_URL);

        WebElement draggable = driver.findElement(By.id("draggable"));
        int height = draggable.getSize().getHeight();
        int width = draggable.getSize().getWidth();

        int pageHeight = driver.manage().window().getSize().getHeight();
        int pageWidth = driver.manage().window().getSize().getWidth();

        moveTo(draggable, driver, pageWidth - width, 0);
        moveTo(draggable, driver, pageWidth - width, pageHeight - 2 * height);
        moveTo(draggable, driver, (pageWidth - width) / 2, (pageHeight - height) / 2);
        moveTo(draggable, driver, 0, pageHeight - 2 * height);
    }

    public void moveTo(WebElement element, WebDriver driver, int desiredX, int desiredY) {
        Actions actions = new Actions(driver);
        int currentX = element.getLocation().getX();
        int currentY = element.getLocation().getY();
        int X = desiredX - currentX;
        int Y = desiredY - currentY;
        actions.dragAndDropBy(element, X, Y).perform();
    }
}
