package pages.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.form.data.Commands;
import pages.form.data.Continent;
import pages.form.data.Profession;
import pages.form.data.Gender;

import java.io.File;
import java.util.Random;

public class FormPage {

    private WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "inputFirstName3")
    private WebElement firstNameInput;

    @FindBy(id = "inputLastName3")
    private WebElement lastNameInput;

    @FindBy(id = "inputEmail3")
    private WebElement emailInput;

    @FindBy(id = "inputAge3")
    private WebElement ageInput;

    @FindBy(id = "selectContinents")
    private WebElement continentSelector;

    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommandsSelector;

    @FindBy(id = "chooseFile")
    private WebElement fileInput;

    @FindBy(css = "[type='submit']")
    private WebElement signInButton;

    @FindBy(id = "validator-message")
    private WebElement validationMessage;

    public FormPage enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public FormPage enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public FormPage enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public FormPage selectSexRadioButton(Gender sex) {
        By sexSelector = By.cssSelector(String.format("[name='gridRadiosSex'][value='%s']", sex.getValue()));
        driver.findElement(sexSelector).click();
        return this;
    }

    public FormPage selectRandomRadioSexButton() {
        By xpathSelector = By.xpath(String.format("(//input[@name='gridRadiosSex'])[%d]", new Random().nextInt(3)+1));
        driver.findElement(xpathSelector).click();
        return this;
    }

    public FormPage enterAge(int age) {
        ageInput.sendKeys(Integer.toString(age));
        return this;
    }

    public FormPage selectYearsOfExperience(int years) {
        By yearsSelector = By.cssSelector(String.format("[name='gridRadiosExperience'][value='%s']", years));
        driver.findElement(yearsSelector).click();
        return this;
    }

    public FormPage selectRandomYearsOfExperience() {
        int randomInt = new Random().nextInt(7) + 1;
        driver.findElement(By.id("gridRadios" + randomInt)).click();
        return this;
    }

    public FormPage selectProfession(Profession profession) {
        By professionsSelector = By.id(profession.getId());
        driver.findElement(professionsSelector).click();
        return this;
    }

    public FormPage selectContinent(Continent continent) {
        Select continentSelect = new Select(continentSelector);
        continentSelect.selectByValue(continent.getValue());
        return this;
    }

    public FormPage selectRandomContinent() {
        Select continentSelect = new Select(continentSelector);
        continentSelect.selectByIndex(new Random().nextInt(7) + 1);
        return this;
    }

    public FormPage selectSeleniumCommand(Commands commands) {
        Select seleniumCommands = new Select(seleniumCommandsSelector);
        seleniumCommands.selectByValue(commands.getValue());
        return this;
    }

    public FormPage addSampleFile() {
        File file = new File("src/test/resources/testFile.txt");
        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage clickSignInButton() {
        signInButton.click();
        return this;
    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }

}
