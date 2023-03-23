package tests.basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.table.TablePage;
import tests.BaseTest;

import java.util.Set;

public class Windows extends BaseTest {

    private String WINDOWS_URL = "http://www.seleniumui.moderntester.pl/windows-tabs.php";

    @Test
    public void windowTest() {
        driver.get(WINDOWS_URL);
        driver.findElement(By.id("newBrowserWindow")).click();

        String parent = driver.getWindowHandle();
        switchDriverToFirstChild(parent);

        new TablePage(driver).getMountains().stream()
                .filter(m -> m.getState().contains("Switzerland"))
                .filter(m -> m.getHeight() > 4000)
                .forEach(System.out::println);

        closeAndReturnToParent(parent);

        driver.findElement(By.id("newMessageWindow")).click();
        switchDriverToFirstChild(parent);
        System.out.println(driver.findElement(By.cssSelector("body")).getText());
        closeAndReturnToParent(parent);

        driver.findElement(By.id("newBrowserTab")).click();
        switchDriverToFirstChild(parent);
        new TablePage(driver).getMountains().stream()
                .filter(m -> m.getState().contains("Switzerland"))
                .filter(m -> m.getHeight() > 4000)
                .forEach(System.out::println);

        closeAndReturnToParent(parent);
    }

    private void switchDriverToFirstChild(String parent) {
        Set<String> windows = driver.getWindowHandles();

        for (String child_window : windows) {
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                driver.manage().window().maximize();
            }
        }
    }

    private void closeAndReturnToParent(String parent) {
        driver.close();
        driver.switchTo().window(parent);
    }
}
