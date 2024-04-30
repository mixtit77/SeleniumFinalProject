package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangePersonalDataPage extends BasePage {
    private static final By myAccountSection = By.id("utility-header-account-link");
    private static final By editButton = By.xpath("//*[@id=\"personal-details\"]/a[1]");
    private static final By firstNameField = By.id("first-name");
    private static final By saveChangesButton = By.xpath("//*[@id=\"personal-details\"]//button");
    private static final By greeting = By.xpath("//*[@id=\"utility-header-greetings\"]");

    public ChangePersonalDataPage(WebDriver driver) {super(driver);}

    public void goToMyAccountSection() {
        WebElement myAccountSectionElement = wait.until(ExpectedConditions.elementToBeClickable(myAccountSection));
        myAccountSectionElement.isEnabled();
        myAccountSectionElement.click();
    }

    public void clickEditButton() {
        WebElement editButtonElement = wait.until(ExpectedConditions.elementToBeClickable(editButton));
        editButtonElement.click();
    }
    String name;
    public String changeFirstName(String nameOne, String nameTwo) {
        WebElement firstNameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        String currentValue = firstNameFieldElement.getAttribute("value");
        firstNameFieldElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        firstNameFieldElement.sendKeys(Keys.DELETE);
        if (currentValue.contains(nameOne)) {
            firstNameFieldElement.sendKeys(nameTwo);
            name = nameTwo;
        } else if (currentValue.contains(nameTwo)) {
            firstNameFieldElement.sendKeys(nameOne);
            name = nameOne;
        } else {
            firstNameFieldElement.sendKeys(nameOne);
            name = nameOne;
        }
        return name;
    }

    public void saveChanges() {
        WebElement saveChangesButtonElement = wait.until(ExpectedConditions.elementToBeClickable(saveChangesButton));
        saveChangesButtonElement.click();
    }

    public void checkThatPersonalDataWasUpdated() {
        WebElement saveChangesButtonElement = driver.findElement(saveChangesButton);
        wait.until(ExpectedConditions.invisibilityOf(saveChangesButtonElement));
        WebElement editButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(editButton));
        editButtonElement.isEnabled();
    }
    public void checkNameAtTheTopOfThePage() {
        WebElement element = driver.findElement(greeting);
        String text = element.getText();
        Assertions.assertEquals("Hello " + name,text);
    }
}

