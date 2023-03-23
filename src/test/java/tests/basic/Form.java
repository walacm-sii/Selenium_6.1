package tests.basic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.form.FormPage;
import tests.BaseTest;
import pages.form.data.Commands;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static pages.form.data.Profession.*;

public class Form extends BaseTest {
    private String FORM_URL = "http://www.seleniumui.moderntester.pl/form.php";
    private FormPage formHandler;

    @BeforeEach
    public void initialize() {
        formHandler = new FormPage(driver);
    }
    @Test
    public void shouldValidateCorrectValidationMessage() {
        driver.get(FORM_URL);
        String actualValidationMessage =
                formHandler
                .enterFirstName("Mati")
                .enterLastName("lala")
                .enterEmail("test@gmail.com")
                .selectRandomRadioSexButton()
                .enterAge(35)
                .selectRandomYearsOfExperience()
                .selectProfession(AUTOMATION_TESTER)
                .selectRandomContinent()
                .selectSeleniumCommand(Commands.SWITCH)
                .selectSeleniumCommand(Commands.WAIT)
                .addSampleFile()
                .clickSignInButton()
                .getValidationMessage();

        assertThat(actualValidationMessage).isEqualTo("Form send with success");
    }
}
