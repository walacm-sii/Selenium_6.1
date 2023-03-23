package tests.other;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

public class HighSite extends BaseTest {
    private String HIGHSITE_URL = "http://www.seleniumui.moderntester.pl/high-site.php";

    @Test
    public void highsite() {
        driver.get(HIGHSITE_URL);
        Actions actions = new Actions(driver);
        while (!isVisible(By.cssSelector("#scroll-button"))) {
            actions.scrollByAmount(0, 100).perform();
        }
    }

    @Test
    public void highsiteJS() {
        driver.get(HIGHSITE_URL);
        while (!isVisible(By.cssSelector("#scroll-button"))) {
            jsScroll();
        }
    }

    private boolean isVisible(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void jsScroll() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)", "");
    }
}
