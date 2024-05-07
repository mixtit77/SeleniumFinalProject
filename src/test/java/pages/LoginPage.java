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
    private static final By searchButton = By.xpath("//*[@id=\"search-form\"]/button");
    private static final By signOutButtonOne = By.id("utility-header-logout-link");
    private static final By signOutButtonTwo = By.xpath("/html/body/div[1]/div/div/div[2]/nav[2]/div/div/div/ul/li[4]/form/button");
    private static final By tescoLogoOne = By.xpath("//*[@id=\"content\"]/div/div/div[2]/div/header/div/div[1]/div[2]/a");
    private static final By tescoLogoTwo = By.cssSelector(".ddsweb-tesco-logo__svg");
    private static final By greetingOne = By.id("utility-header-greetings");
    private static final By greetingTwo = By.xpath("/html/body/div[1]/div/div/div[2]/nav[2]/div/div/div/ul/li[1]/div");
    private static final By warningMessageElementOne = By.xpath("//*[contains(text(), 'Unfortunately we do not recognise those details.')]");
    private static final By warningMessageElementTwo = By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div[2]/div/div[2]/p[1]");

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
        try {
            wait.until(ExpectedConditions.elementToBeClickable(signOutButtonOne)).isEnabled();
            driver.findElement(signOutButtonOne).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(signInSection));
        } catch (Exception e) {
            System.out.println("Sign out one not found. Trying sign out two.");
        }
        try{
            wait.until(ExpectedConditions.elementToBeClickable(signOutButtonTwo)).isEnabled();
            driver.findElement(signOutButtonTwo).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(signInSection));
        } catch (Exception e) {
            System.out.println("Sign out two not found.");
        }
    }

    public void waitUntilRedirectToMainPage() {
        driver.get(Settings.TESCO_MAIN_PAGE_URL);
        wait.until(ExpectedConditions.urlToBe(Settings.TESCO_MAIN_PAGE_URL));
    }

    public void waitVisibilityLogo() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(tescoLogoOne));
        } catch (Exception e) {
            System.out.println("Tesco logo one not found. Trying logo two.");
        }
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(tescoLogoTwo));
        } catch (Exception e) {
            System.out.println("Tesco logo two not found.");
        }
    }

    public void checkTextAtTheTopOfThePage(String greetings) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(greetingOne));
            WebElement element = driver.findElement(greetingOne);
            String text = element.getText();
            Assertions.assertTrue(text.contains(greetings));
        } catch (Exception e) {
            System.out.println("Greeting one not found. Trying Greeting two.");
        }
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(greetingTwo));
            WebElement element = driver.findElement(greetingTwo);
            String text = element.getText();
            Assertions.assertTrue(text.contains(greetings));
        } catch (Exception e) {
            System.out.println("Greeting two not found.");
        }
    }

    public void checkErrorMessage(String warningMessage) {
        try{
            wait.until(ExpectedConditions.textToBe(warningMessageElementOne, warningMessage));
        } catch (Exception e) {
            System.out.println("Warning Message one not found.");
        }
        try{
            wait.until(ExpectedConditions.textToBe(warningMessageElementTwo, warningMessage));
        } catch (Exception e) {
            System.out.println("Warning Message two not found.");
        }

    }

    public void checkSignInSection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInSection));
    }

    public void refreshPage() {
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
    }
}

