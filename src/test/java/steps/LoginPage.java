package steps;

import driver.Settings;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage{

//    WebDriver driver;
//    WebDriverWait wait;
//
//    @Before
//    public void initializeDriver() {
//        driver = DriverInitializer.initalizeDriver(BrowserType.CHROME);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        driver.manage().window().maximize();
//    }
//
//    @After
//    public void closeDriver() {
//        driver.quit();
//    }

    private static final By cookieButton = By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button");
    private static final By signInSection = By.xpath("//span[text()='Sign in']");
    private static final By tescoLogo = By.className("ddsweb-tesco-logo__svg");
    private static final By tescoLogoOnSignInSection = By.id("tesco-logo-d");
    private static final By emailField = By.id("email");
    private static final By passwordField = By.id("password");
    private static final By signInButton = By.id("signin-button");
    private static final By greeting = By.xpath("//*[@id=\"utility-header-greetings\"]");
    private static final By warningMessageElement = By.xpath("//*[@class=\"styled__StyledBodyText-sc-119w3hf-5 cjzjrS beans-notification__title\"]");
    private static final By signOutButton = By.id("utility-header-logout-link");

    @Given("The user open Tesco website")
    public void iOpenTescoWebsite() {
        driver.get(Settings.TESCO_MAIN_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(tescoLogo));
    }

    @And("the user accept privacy policy")
    public void iAcceptPrivacyPolicy() {
        WebElement cookieButtonElement = driver.findElement(cookieButton);
        wait.until(ExpectedConditions.visibilityOf(cookieButtonElement)).isEnabled();
        cookieButtonElement.click();
    }

    @When("the User goes to the sign in section")
    public void theUserGoesToTheSignInSection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInSection)).isEnabled();
        driver.findElement(signInSection).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(tescoLogoOnSignInSection));
    }

    @When("the User enters his correct login {string}")
    public void theUserEntersHisCorrectLogin(String email) {
        WebElement emailFieldElement = driver.findElement(emailField);
        wait.until(ExpectedConditions.visibilityOf(emailFieldElement)).isEnabled();
        emailFieldElement.clear();
        emailFieldElement.sendKeys(email);
    }

    @And("the User enters his correct password {string}")
    public void theUserEntersHisCorrectPassword(String password) {
        WebElement passwordFieldElement = driver.findElement(passwordField);
        wait.until(ExpectedConditions.visibilityOf(passwordFieldElement)).isEnabled();
        passwordFieldElement.clear();
        passwordFieldElement.sendKeys(password);
    }

    @And("the User clicks the sign in button")
    public void theUserClicksTHeSignInButton() {
        WebElement signInButtonElement = driver.findElement(signInButton);
        wait.until(ExpectedConditions.visibilityOf(signInButtonElement)).isEnabled();
        signInButtonElement.click();
    }
    @Then("the User is successfully authenticated")
    public void theUserIsSuccessfullyAuthenticated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(tescoLogo));

    }

    @And("the user redirected to the main page")
    public void theUserRedirectedToTheMainPage() {
        wait.until(ExpectedConditions.urlToBe(Settings.TESCO_MAIN_PAGE_URL));
    }

    @And("the User sees {string} at the top of the page")
    public void theUserSeesHisNameAtTheTopOfThePage(String greetings) {
        WebElement element = driver.findElement(greeting);
        String text = element.getText();
        text.contains(greetings);
        //wait.until(ExpectedConditions.textToBe(greeting,greetings));


    }

    @Then("the User sees warning message {string}")
    public void theUserSeesWarningMessage(String warningMessage) {
        wait.until(ExpectedConditions.textToBe(warningMessageElement, warningMessage));
    }


    @And("the User enters incorrect password {string}")
    public void theUserEntersIncorrectPassword(String password) {
        WebElement passwordFieldElement = driver.findElement(passwordField);
        wait.until(ExpectedConditions.visibilityOf(passwordFieldElement)).isEnabled();
        passwordFieldElement.clear();
        passwordFieldElement.sendKeys(password);
    }

    @Then("the User clicks on the Sign out button")
    public void theUserClicksOnTheSignOutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton)).isEnabled();
        driver.findElement(signOutButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(tescoLogo));
    }

    @And("the User sees Sign in button")
    public void theUserSeesSignInButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInSection)).isEnabled();
    }
    @And("the User updates page")
    public void theUserUpdatesPage() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(tescoLogo));
    }

    @After
    public void tearDown() {
        BasePage.closeDriver();
    }


}
