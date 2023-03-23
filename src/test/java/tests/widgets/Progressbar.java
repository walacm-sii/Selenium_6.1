package tests.widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Progressbar extends BaseTest {

    private String PROGRESSBAR_URL = "http://www.seleniumui.moderntester.pl/progressbar.php";

    @Test
    public void progressBar() {
        driver.get(PROGRESSBAR_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.attributeContains(By.cssSelector(".ui-progressbar-value"), "class", "ui-progressbar-complete"));
        assertThat(driver.findElement(By.cssSelector(".progress-label")).getText()).isEqualTo("Complete!");
    }

}
