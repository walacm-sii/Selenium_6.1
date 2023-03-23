package tests.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.table.RowPage;
import pages.table.TablePage;
import tests.BaseTest;

import java.util.List;

public class NewTable extends BaseTest {

    private String TABLE_URL = "http://www.seleniumui.moderntester.pl/table.php";
    private TablePage tablePage;

    @BeforeEach
    public void testSetup() {
        tablePage = new TablePage(driver);
    }

    @Test
    public void tableTest() {
        driver.get(TABLE_URL);
        List<RowPage> mountains = tablePage.getMountains();

        mountains.stream()
                .filter(m -> m.getState().contains("Switzerland"))
                .filter(m -> m.getHeight() > 4000)
                .forEach(System.out::println);
    }
}
