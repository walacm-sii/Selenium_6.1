package tests.other;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

public class HighSite extends BaseTest {
    private String HIGHSITE_URL = "http://www.seleniumui.moderntester.pl/high-site.php";

    @Test
    public void highsite() throws IOException {
        driver.get(HIGHSITE_URL);
        Actions actions = new Actions(driver);
        while (!isVisible(By.cssSelector("#scroll-button"))) {
            actions.scrollByAmount(0, 100).perform();
        }
        takeScreenshot();
    }

    @Test
    public void highsiteJS() throws IOException {
        driver.get(HIGHSITE_URL);
        while (!isVisible(By.cssSelector("#scroll-button"))) {
            jsScroll();
        }
        takeScreenshot();
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

    private void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
                + "submit" + new Timestamp(System.currentTimeMillis()).toString().replace(" ", "_")
                .replace(":", ".") + ".png");
        FileUtils.copyFile(scrFile, file);
    }
}
