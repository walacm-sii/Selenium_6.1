package tests.basic.data;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MountainsList {
    private List<Mountain> mountains;

    public MountainsList(List<WebElement> dataList) {
        mountains = new ArrayList<>();
        extractDataFromWebElements(dataList);
    }

    private void extractDataFromWebElements(List<WebElement> dataList) {
        for(int i = 0; i < dataList.size(); i+=5) {
            mountains.add(
                    new Mountain(
                            Integer.parseInt(dataList.get(i).getText()),
                            dataList.get(i+1).getText(),
                            dataList.get(i+2).getText(),
                            dataList.get(i+3).getText(),
                            Integer.parseInt(dataList.get(i+4).getText())));
        }
    }

    public List<Mountain> getMountains() {
        return mountains;
    }

}
