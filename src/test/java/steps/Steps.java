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
import pages.SearchPage;
import pages.SortByPricePage;

public class Steps {
    private WebDriver driver;
    private WebDriverWait wait;

    private LoginPage loginPage;
    private ChangePersonalDataPage changePersonalDataPage;
    private SearchPage searchPage;
    private SortByPricePage sortByPricePage;

    public Steps() {
        this.driver = DriverInitializer.initChrome();
        this.loginPage = new LoginPage(this.driver);
        this.changePersonalDataPage = new ChangePersonalDataPage(this.driver);
        this.searchPage = new SearchPage(this.driver);
        this.sortByPricePage = new SortByPricePage(this.driver);
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
    @Given("the User sees the search field on the main page")
    public void theUserSeesTheSearchFieldOnTheMainPage() {
        searchPage.checkSearchField();
    }
    @When("the User enters {string} in the search field")
    public void theUserEntersProductInTheSearchField(String product) {
        searchPage.enterTextInTheSearchField(product);
    }

    @Then("the User sees the search results with {string}")
    public void theUserSeesTheSearchResultsWithProduct(String product) {
        searchPage.checkResultsWithProduct(product);
    }

    @And("the User clicks the search button")
    public void theUserClicksTheSearchButton() {
        searchPage.clickSearchButton();
    }
    @After
    public void tearDown() {
        loginPage.closeDriver();
    }

    @And("the User sees the add button for each product")
    public void theUserSeesTheAddButtonForEachProduct() {
        searchPage.checkExistingButtons();
    }

    @And("the User goes to the Promotions section on the main page")
    public void theUserGoesToThePromotionsSectionOnTheMainPage(){
        sortByPricePage.goToThePromotionSection();
    }

    @And("the User goes to any suggested section on the promotion page")
    public void theUserGoesToAnySuggestedSectionOnThePromotionPage(){
        sortByPricePage.goToAnySuggestedSection();
    }

    @When("the User clicks on dropdown list sort by high to low")
    public void theUserClicksOnDropdownListSortByHighToLow(){
        sortByPricePage.clickOnSortByHighToLow();
    }

    @Then("the User sees the results which sorted by price high to low")
    public void theUserSeesTheResultsWhichSortedByPriceHighToLow() {
        sortByPricePage.checkSortedByHighToLowResults();
    }

    @When("the User clicks on dropdown list sort by low to high")
    public void theUserClicksOnDropdownListSortByLowToHigh() {
        sortByPricePage.clickOnSortByLowToHigh();
    }

    @Then("the User sees the results which sorted by price low to high")
    public void theUserSeesTheResultsWhichSortedByPriceLowToHigh() {
        sortByPricePage.checkSortedByLowToHighResults();
    }

    @When("the User goes to the My account section")
    public void theUserGoesToTheMyAccountSection() {
        changePersonalDataPage.goToMyAccountSection();
    }
}

