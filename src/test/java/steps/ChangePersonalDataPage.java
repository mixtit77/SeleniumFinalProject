package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChangePersonalDataPage extends BasePage {
    private static final By myAccountSection = By.id("utility-header-account-link");
    private static final By editButton = By.xpath("//*[@id=\"personal-details\"]/a[1]");
    private static final By firstNameFIeld = By.id("first-name");
    private static final By saveChangesButton = By.xpath("//*[@id=\"personal-details\"]//button");
    private static final By SaveChangesButtonTwo = By.xpath("(//*[@class='account-settings--form--actions--submit button button-primary'])[1]");
    private static final By emailField = By.id("email");

    @When("the User goes to the My account section")
    public void theUserGoesToTheMyAccountSection() {
        WebElement myAccountSectionElement = driver.findElement(myAccountSection);
        wait.until(ExpectedConditions.visibilityOf(myAccountSectionElement)).isEnabled();
        myAccountSectionElement.click();
    }

    @And("The User clicks on the Edit button in the personal details section")
    public void theUserClicksOnTheEditButtonInThePersonalDetailsSection() {
        WebElement editButtonElement = driver.findElement(editButton);
        wait.until(ExpectedConditions.visibilityOf(editButtonElement)).isEnabled();
        editButtonElement.click();
    }

    @And("the User changes his first name to {string} {string}")
    public void theUserChangesHisFirstName(String nameOne, String nameTwo) {
        WebElement firstNameFieldElement = driver.findElement(firstNameFIeld);
        wait.until(ExpectedConditions.visibilityOf(firstNameFieldElement)).isEnabled();

        String currentValue = firstNameFieldElement.getAttribute("value");
        //String text = firstNameFieldElement.getText();
        firstNameFieldElement.clear();
        if (currentValue.contains(nameOne)) {
            firstNameFieldElement.sendKeys(nameTwo);
        } else if (currentValue.contains(nameTwo)) {
            firstNameFieldElement.clear();
            firstNameFieldElement.sendKeys(nameOne);
        } else {
            firstNameFieldElement.clear();
            firstNameFieldElement.sendKeys("Papa");
        }
    }


    @And("the User clicks on the Save changes button in the personal details section")
    public void theUserClicksOnTheSaveChangesButtonInThePersonalDetailsSection() {
        WebElement saveChangesButtonElement = driver.findElement(saveChangesButton);
        wait.until(ExpectedConditions.visibilityOf(saveChangesButtonElement)).isEnabled();
        saveChangesButtonElement.click();
    }

    @Then("the User sees that personal data was successfully updated")
    public void theUserSeesThatPersonalDataWasSuccessfullyUpdated() {
        WebElement saveChangesButtonElement = driver.findElement(saveChangesButton);
        wait.until(ExpectedConditions.invisibilityOf(saveChangesButtonElement));
        WebElement editButtonElement = driver.findElement(editButton);
        wait.until(ExpectedConditions.visibilityOf(editButtonElement)).isEnabled();
    }

    @And("the User sees changed first name at the top of the page")
    public void theUserSeesChangedFirstNameAtTheTopOfThePage() {

    }
}
