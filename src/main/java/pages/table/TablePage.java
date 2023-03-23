package pages.table;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TablePage {
    public TablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "tbody tr")
    private List<WebElement> rows;

    public List<RowPage> getMountains() {
        return rows.stream().map(RowPage::new).toList();
    }
}
