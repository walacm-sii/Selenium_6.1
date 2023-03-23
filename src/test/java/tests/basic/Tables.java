package tests.basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;
import tests.basic.data.Mountain;
import tests.basic.data.MountainsList;

import java.util.List;

public class Tables extends BaseTest {

    private String TABLE_URL = "http://www.seleniumui.moderntester.pl/table.php";

    @Test
    public void table() {
        driver.get(TABLE_URL);
        List<WebElement> table = driver.findElements(By.xpath("//table/tbody/tr/*"));
        List<Mountain> mountains = new MountainsList(table).getMountains();

        mountains.stream()
                .filter(mountain -> mountain.state().contains("Switzerland"))
                .filter(mountain -> mountain.height() > 4000)
                .forEach(System.out::println);

    }
}
