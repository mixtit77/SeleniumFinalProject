package steps;

import driver.DriverInitializer;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ChangePersonalDataPage;
import pages.LoginPage;

public class Steps {
    private WebDriver driver;
    private WebDriverWait wait;

    private LoginPage loginPage;
    private ChangePersonalDataPage changePersonalDataPage;

    public Steps() {
        this.driver = DriverInitializer.initChrome();
        this.loginPage = new LoginPage(this.driver);
        this.changePersonalDataPage = new ChangePersonalDataPage(this.driver);
    }

    @Given("The user open Tesco website")
    public void iOpenTescoWebsite() {
        loginPage.openWebsite();
    }

    @And("the user accept privacy policy")
    public void iAcceptPrivacyPolicy() {
        loginPage.acceptPrivacyPolicy();
    }

    @When("the User goes to the sign in section")
    public void theUserGoesToTheSignInSection() {
        loginPage.goToSignInSection();
    }

    @And("the User enters his correct login {string}")
    public void theUserEntersHisCorrectLogin(String email) {
        loginPage.enterEmail(email);
    }

    @And("the User enters his correct password {string}")
    public void theUserEntersHisCorrectPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("the User clicks the sign in button")
    public void theUserClicksTHeSignInButton() {
        loginPage.clickSignInButton();
    }
    @And("the User enters incorrect password {string}")
    public void theUserEntersIncorrectPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("the User is successfully authenticated")
    public void theUserIsSuccessfullyAuthenticated() {
        loginPage.waitVisibilityLogo();
    }

    @And("the user redirected to the main page")
    public void theUserRedirectedToTheMainPage() {
        loginPage.waitUntilRedirectToMainPage();
    }

    @And("the User sees {string} at the top of the page")
    public void theUserSeesHisNameAtTheTopOfThePage(String greetings) {
        loginPage.checkTextAtTheTopOfThePage(greetings);
    }

    @Then("the User sees warning message {string}")
    public void theUserSeesWarningMessage(String warningMessage) {
        loginPage.checkErrorMessage(warningMessage);
    }

    @Then("the User clicks on the Sign out button")
    public void theUserClicksOnTheSignOutButton() {
        loginPage.signOutClick();
    }

    @And("the User sees Sign in button")
    public void theUserSeesSignInButton() {
        loginPage.checkSignInSection();
    }

    @And("the User updates page")
    public void theUserUpdatesPage() {
        loginPage.refreshPage();
    }
    @When("the User goes to the My account section")
    public void theUserGoesToTheMyAccountSection() {
        changePersonalDataPage.goToMyAccountSection();
    }

    @And("The User clicks on the Edit button in the personal details section")
    public void theUserClicksOnTheEditButtonInThePersonalDetailsSection() {
        changePersonalDataPage.clickEditButton();
    }

    @And("the User changes his first name to {string} {string}")
    public void theUserChangesHisFirstName(String nameOne, String nameTwo) {
        changePersonalDataPage.changeFirstName(nameOne,nameTwo);
    }

    @And("the User clicks on the Save changes button in the personal details section")
    public void theUserClicksOnTheSaveChangesButtonInThePersonalDetailsSection() {
        changePersonalDataPage.saveChanges();
    }

    @Then("the User sees that personal data was successfully updated")
    public void theUserSeesThatPersonalDataWasSuccessfullyUpdated() {
        changePersonalDataPage.checkThatPersonalDataWasUpdated();
    }

    @And("the User sees changed first name at the top of the page")
    public void theUserSeesChangedFirstNameAtTheTopOfThePage() {
        changePersonalDataPage.checkNameAtTheTopOfThePage();
    }
    @After
    public void tearDown() {
        loginPage.closeDriver();
    }
}

