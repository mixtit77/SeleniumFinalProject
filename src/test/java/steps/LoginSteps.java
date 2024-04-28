package steps;

import driver.Settings;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver() {
        driver.quit();
    }

    @Given("I open Tesco website")
    public void iOpenTescoWebsite() {
        driver.get(Settings.TESCO_MAIN_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")));
    }

    @And("I accept privacy policy")
    public void iAcceptPrivacyPolicy() {
        driver.findElement(By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button")).click();
    }

    @When("the User goes to the sign in section")
    public void theUserGoesToTheSignInSection() throws InterruptedException {
        WebElement signInSection = driver.findElement(By.xpath("//span[text()='Sign in']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ddsweb-tesco-logo__svg")));
        signInSection.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tesco-logo-d")));
    }

    @And("the User enters his correct login {string}")
    public void theUserEntersHisCorrectLogin(String email) {
        WebElement emailField = driver.findElement(By.id("email"));
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }

    @And("the User enters his correct password {string}")
    public void theUserEntersHisCorrectPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @And("the User clicks the sign in button")
    public void theUserClicksTHeSignInButton() {
        WebElement signInButton = driver.findElement(By.id("signin-button"));
        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }
    @Then("the User is successfully authenticated")
    public void theUserIsSuccessfullyAuthenticated() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ddsweb-tesco-logo__svg")));
    }

    @And("the user redirected to the main page")
    public void theUserRedirectedToTheMainPage() {
        wait.until(ExpectedConditions.urlToBe("https://bevasarlas.tesco.hu/groceries/en-GB/"));
    }

    @And("the User sees his name at the top of the page")
    public void theUserSeesHisNameAtTheTopOfThePage() {
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id=\"utility-header-greetings\"]"), "Hello Mikhail"));
    }

    @Then("the User sees warning message {string}")
    public void theUserSeesWarningMessage(String warningMessage) {
        wait.until(ExpectedConditions.textToBe(By.xpath("//*[@class=\"styled__StyledBodyText-sc-119w3hf-5 cjzjrS beans-notification__title\"]"), warningMessage));
    }


    @And("the User enters incorrect password {string}")
    public void theUserEntersIncorrectPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
}
