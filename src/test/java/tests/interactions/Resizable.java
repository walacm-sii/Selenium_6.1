package tests.interactions;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

public class Resizable extends BaseTest {

    private String RESIZABLE_URL = "http://www.seleniumui.moderntester.pl/resizable.php";

    @Test
    public void resizable() {
        driver.get(RESIZABLE_URL);
        int OFFSET = 18;
        WebElement resizableHandle = driver.findElement(By.cssSelector(".ui-resizable-se"));
        Actions actions = new Actions(driver);

        moveElementAndPrintDifferenceInPosition(actions, resizableHandle, 10, 0, OFFSET);
        moveElementAndPrintDifferenceInPosition(actions, resizableHandle, 0, 10, OFFSET);
        moveElementAndPrintDifferenceInPosition(actions, resizableHandle, 10, 10, OFFSET);
    }

    private void moveElementAndPrintDifferenceInPosition(Actions actions, WebElement element, int X, int Y, int offset) {
        String w1 = driver.findElement(By.id("resizable")).getCssValue("width");
        String h1 = driver.findElement(By.id("resizable")).getCssValue("height");
        actions.dragAndDropBy(element, X + offset, Y + offset).perform();
        String w2 = driver.findElement(By.id("resizable")).getCssValue("width");
        String h2 = driver.findElement(By.id("resizable")).getCssValue("height");
        System.out.println("Element moved in X axis: " + calculateDifferenceValue(w1, w2) + ", Y axis: " + calculateDifferenceValue(h1, h2));
    }

    private int calculateDifferenceValue(String a, String b) {
        return (parseString(b)- parseString(a));
    }

    private int parseString(String string1) {
        return Integer.parseInt(string1.replace("px", ""));
    }

}
