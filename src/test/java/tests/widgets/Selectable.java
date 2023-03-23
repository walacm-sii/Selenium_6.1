package tests.widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import tests.BaseTest;

import java.util.Random;

public class Selectable extends BaseTest {

    private String SELECTMENU_URL = "http://www.seleniumui.moderntester.pl/selectmenu.php";

    @Test
    public void selectable() {
        driver.get(SELECTMENU_URL);

        selectOptionFrom("speed", By.xpath("(.//div)[" + (new Random().nextInt(5) + 1) + "]"));
        selectOptionFrom("files", By.xpath(".//div[contains(text(), 'Some unknown file')]"));
        selectOptionFrom("number", By.xpath("(.//div)[5]"));
        selectOptionFrom("salutation", By.xpath("(.//div)[" + (new Random().nextInt(4) + 2) + "]"));

    }

    @Test
    public void selectableWithJS() {
        driver.get(SELECTMENU_URL);
        changeElementDisplayValue(driver, "speed", "block");
        Select speedSelect = new Select(driver.findElement(By.id("speed")));
        speedSelect.selectByIndex(new Random().nextInt(5));

        changeElementDisplayValue(driver, "files", "block");
        Select fileSelect = new Select(driver.findElement(By.id("files")));
        fileSelect.selectByVisibleText("Some unknown file");

        changeElementDisplayValue(driver, "number", "block");
        Select numberSelect = new Select(driver.findElement(By.id("number")));
        numberSelect.selectByIndex(3);

        changeElementDisplayValue(driver, "salutation", "block");
        Select titleSelect = new Select(driver.findElement(By.id("salutation")));
        titleSelect.selectByIndex(new Random().nextInt(4) + 1);
    }

    private void changeElementDisplayValue(WebDriver driver, String id, String newValue) {
        ((JavascriptExecutor) driver).executeScript("document.getElementById('" + id + "').style.display='" + newValue + "';");
    }

    private void selectOptionFrom(String name, By by) {
        driver.findElement(By.id(name + "-button")).click();
        driver.findElement(By.xpath("//ul[@id='" + name + "-menu']")).findElement(by).click();
    }
}
