package tests.basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import tests.BaseTest;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Alerts extends BaseTest {

    private String ALERT_URL = "http://www.seleniumui.moderntester.pl/alerts.php";

    @Test
    public void simpleAlertPopUp() {
        driver.get(ALERT_URL);
        driver.findElement(By.id("simple-alert")).click();
        driver.switchTo().alert().accept();
        String alertMessage = driver.findElement(By.id("simple-alert-label")).getText();
        assertThat(alertMessage).isEqualTo("OK button pressed");
    }

    @Test
    public void promptAlertBox() {
        driver.get(ALERT_URL);
        driver.findElement(By.id("prompt-alert")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Lord Vader");
        alert.accept();
        String alertMessage = driver.findElement(By.id("prompt-label")).getText();
        assertThat(alertMessage).isEqualTo("Hello Lord Vader! How are you today?");
    }

    @Test
    public void confirmAlertBox() {
        driver.get(ALERT_URL);
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().accept();
        String alertMessage = driver.findElement(By.id("confirm-label")).getText();
        assertThat(alertMessage).isEqualTo("You pressed OK!");
        driver.findElement(By.id("confirm-alert")).click();
        driver.switchTo().alert().dismiss();
        alertMessage = driver.findElement(By.id("confirm-label")).getText();
        assertThat(alertMessage).isEqualTo("You pressed Cancel!");
    }

    @Test
    public void delayedAlert() {
        driver.get(ALERT_URL);
        driver.findElement(By.id("delayed-alert")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoAlertPresentException.class);

        wait.until(driver -> driver.switchTo().alert()).accept();
        String alertMessage = driver.findElement(By.id("delayed-alert-label")).getText();
        assertThat(alertMessage).isEqualTo("OK button pressed");
    }
}
