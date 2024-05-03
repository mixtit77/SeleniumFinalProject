package pages;

import driver.Settings;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private static final By cookieButton = By.xpath("//*[@id=\"sticky-bar-cookie-wrapper\"]/span/div/div/div[2]/form[1]/button");
    private static final By signInSection = By.xpath("//span[text()='Sign in']");
    private static final By emailField = By.id("email");
    private static final By passwordField = By.id("password");
    private static final By signInButton = By.id("signin-button");
    private static final By tescoLogo = By.xpath("(//*[@class=\"ddsweb-tesco-logo__svg\"])[1]");
    private static final By signOutButton = By.id("utility-header-logout-link");
    private static final By greeting = By.xpath("//*[@id=\"utility-header-greetings\"]");
    private static final By greeting2 = By.cssSelector("#utility-header-greetings");
    private static final By searchButton = By.xpath("//*[@id=\"search-form\"]/button");
    private static final By warningMessageElement = By.cssSelector("//*[@class=\"styled__StyledBodyText-sc-119w3hf-5 cjzjrS beans-notification__title\"]");
    private static final By warningMessageElement2 = By.cssSelector(".styled__StyledBodyText-sc-119w3hf-5.cjzjrS.beans-notification__title");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openWebsite() {
        driver.get(Settings.TESCO_MAIN_PAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInSection));
        WebElement signInSectionElement = driver.findElement(signInSection);
        signInSectionElement.isEnabled();

    }

    public void acceptPrivacyPolicy() {
        WebElement cookieButtonElement = wait.until(ExpectedConditions.elementToBeClickable(cookieButton));
        cookieButtonElement.click();
    }

    public void goToSignInSection() {
        WebElement signInSectionElement = wait.until(ExpectedConditions.elementToBeClickable(signInSection));
        signInSectionElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
    }

    public void enterEmail(String email) {
        WebElement emailFieldElement = driver.findElement(emailField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).isEnabled();
        emailFieldElement.clear();
        emailFieldElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordFieldElement = driver.findElement(passwordField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).isEnabled();
        passwordFieldElement.clear();
        passwordFieldElement.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInButtonElement = driver.findElement(signInButton);
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).isEnabled();
        signInButtonElement.click();
    }

    public void signOutClick() {
        wait.until(ExpectedConditions.elementToBeClickable(signOutButton)).isEnabled();
        driver.findElement(signOutButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInSection));
    }

    public void waitUntilRedirectToMainPage() {
        driver.get(Settings.TESCO_MAIN_PAGE_URL);
        wait.until(ExpectedConditions.urlToBe(Settings.TESCO_MAIN_PAGE_URL));
    }

    public void waitVisibilityLogo() {
       //wait.until(ExpectedConditions.visibilityOfElementLocated(tescoLogo));
    }

    public void checkTextAtTheTopOfThePage(String greetings) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(greeting2));
        WebElement element = driver.findElement(greeting2);
        String text = element.getText();
        Assertions.assertTrue(text.contains(greetings));
    }

    public void checkErrorMessage(String warningMessage) {
        wait.until(ExpectedConditions.textToBe(warningMessageElement2, warningMessage));
    }

    public void checkSignInSection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInSection));
    }

    public void refreshPage() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
    }
}

