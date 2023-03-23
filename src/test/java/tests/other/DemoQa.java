package tests.other;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tests.BaseTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DemoQa extends BaseTest {
    private String DEMO_URL = "https://demoqa.com/automation-practice-form";

    @Test
    public void demo() {
        driver.get(DEMO_URL);

        WebElement subjectInput = driver.findElement(By.cssSelector("#subjectsInput"));
        subjectInput.sendKeys("m");
        selectOptionFromSubjectInput("Maths");
        subjectInput.sendKeys("a");
        selectOptionFromSubjectInput("Arts");
        List<String> inputs = driver.findElements(By.cssSelector(".subjects-auto-complete__multi-value__label"))
                .stream().map(WebElement::getText).toList();

        assertThat(inputs.contains("Maths")).isTrue();
        assertThat(inputs.contains("Arts")).isTrue();
        assertThat(inputs.size()).isEqualTo(2);
    }

    private void selectOptionFromSubjectInput(String option) {
        driver.findElement(By.xpath("//div[contains(@class, 'subjects-auto-complete__menu-list')]/div[contains(text(), '" + option + "')]")).click();
    }
}
