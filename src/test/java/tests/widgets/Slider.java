package tests.widgets;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class Slider extends BaseTest {
    private String SLIDER_URL = "http://www.seleniumui.moderntester.pl/slider.php";

    @Test
    public void slider() {
        driver.get(SLIDER_URL);
        moveSlider(50);
        assertThat(getSliderActualPosition()).isEqualTo(50);
        moveSlider(80);
        assertThat(getSliderActualPosition()).isEqualTo(80);
        moveSlider(80);
        assertThat(getSliderActualPosition()).isEqualTo(80);
        moveSlider(20);
        assertThat(getSliderActualPosition()).isEqualTo(20);
        moveSlider(0);
        assertThat(getSliderActualPosition()).isEqualTo(0);
    }

    private void moveSlider(int desiredPosition) {
        WebElement slider = driver.findElement(By.id("custom-handle"));
        int actualPosition = getSliderActualPosition();
        if(desiredPosition > actualPosition) {
            move(slider, desiredPosition - actualPosition, Keys.ARROW_RIGHT);
        } else if (desiredPosition < actualPosition ){
            move(slider, actualPosition - desiredPosition, Keys.ARROW_LEFT);
        }
    }

    private void move(WebElement slider, int number, Keys key) {
        for(int i = 0; i < number; i++) {
            slider.sendKeys(key);
        }
    }

    private int getSliderActualPosition() {
        return Integer.parseInt(driver.findElement(By.id("custom-handle")).getText());
    }
}
