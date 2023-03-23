package tests.widgets;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Menu extends BaseTest {
    private String MENU_URL = "http://www.seleniumui.moderntester.pl/menu-item.php";
    private WebDriverWait wait;

    private static Stream<Arguments> testDataProvider() {
        return Stream.of(
                Arguments.of("Mateusz", "test@gmail.com", "aaaaaaa")
        );
    }

    @ParameterizedTest
    @MethodSource("testDataProvider")
    public void menu(String name, String email, String password) {
        driver.get(MENU_URL);
        Actions actions = new Actions(driver);

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        moveMouseToElement(actions, xpathContainText("Music"));
        moveMouseToElement(actions, xpathContainText("Jazz"));
        moveMouseToElement(actions, xpathContainText("Modern"));
        driver.findElement(xpathContainText("Modern")).click();

        moveMouseToElement(actions, xpathContainText("Widgets"));
        moveMouseToElement(actions, xpathContainText("Modal dialog"));
        driver.findElement(xpathContainText("Modal dialog")).click();

        driver.findElement(By.id("create-user")).click();

        clearAndSendKeysToField("name", name);
        clearAndSendKeysToField("email", email);
        clearAndSendKeysToField("password", password);

        driver.findElement(By.xpath("//button[contains(text(), 'Create an account')]")).click();

        List<WebElement> users = driver.findElements(By.cssSelector("#users > tbody > tr"));
        Boolean isUserAdded = users.stream().anyMatch(user -> user.getText().contentEquals(name + " " + email + " " + password));
        assertThat(isUserAdded).isTrue();
    }

    private void moveMouseToElement(Actions actions, By by) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        actions.moveToElement(driver.findElement(by)).perform();
    }

    private void clearAndSendKeysToField(String id, String text) {
        var element = driver.findElement(By.id(id));
        element.clear();
        element.sendKeys(text);
    }

    private By xpathContainText(String text) {
        return By.xpath("//*[contains(text(), '" + text + "')]");
    }
}
