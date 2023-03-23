package pages.table;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class RowPage {

    public RowPage(WebElement element) {
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }

    @FindBy(css = "th")
    private WebElement rank;

    @FindBy(xpath = "./td[1]")
    private WebElement peak;
    @FindBy(xpath = "./td[2]")
    private WebElement mountainRange;
    @FindBy(xpath = "./td[3]")
    private WebElement state;
    @FindBy(xpath = "./td[4]")
    private WebElement height;

    public int getRank() {
        return Integer.parseInt(rank.getText());
    }

    public String getPeak() {
        return peak.getText();
    }

    public String getMountainRange() {
        return mountainRange.getText();
    }

    public String getState() {
        return state.getText();
    }

    public int getHeight() {
        return Integer.parseInt(height.getText());
    }

    @Override
    public String toString() {
        return "Rank: " + getRank() + ", Peak: " + getPeak() + ", Mountain range: " + getMountainRange();
    }
}
