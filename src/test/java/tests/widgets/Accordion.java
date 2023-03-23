package tests.widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;

public class Accordion extends BaseTest {
    private String ACCORDION_URL = "http://www.seleniumui.moderntester.pl/accordion.php";

    @Test
    public void accordion() {
        driver.get(ACCORDION_URL);
        openSection("ui-id-1");
        System.out.println(getAccordionSectionText("#ui-id-2 > p"));
        openSection("ui-id-3");
        System.out.println(getAccordionSectionText("#ui-id-4 > p"));
        openSection("ui-id-5");
        System.out.println(getAccordionSectionText("#ui-id-6 > p"));
        openSection("ui-id-7");
        System.out.println(getAccordionSectionText("#ui-id-8 > p"));
    }

    private void openSection(String id) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement accordion = driver.findElement(By.id(id));
        if (!accordion.getAttribute("aria-expanded").equals("true")) {
            accordion.click();
            wait.until(ExpectedConditions.attributeContains(By.id(id), "aria-expanded", "true"));
        }
    }

    private String getAccordionSectionText(String id) {
        return driver.findElement(By.cssSelector(id)).getText();
    }
}
