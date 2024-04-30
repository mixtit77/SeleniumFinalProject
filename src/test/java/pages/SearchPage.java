package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class SearchPage extends BasePage{
    private static final By searchField = By.id("search-input");
    private static final By searchButton = By.xpath("//*[@id=\"search-form\"]/button");
    private static final By results = By.xpath("//*[@id=\"results\"]/h1");
    private List<WebElement> productList = driver.findElements(By.xpath("//*[@class='styled__StyledLIProductItem-sc-198470k-1 fmKLdy product-list--list-item']"));
    private static final By addButtons = By.className("base-components__BaseElement-sc-1mosoyj-0 styled__TextSpan-rsekm1-4 oznwo GDiMp beans-button__text");
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void checkSearchField(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField)).isEnabled();
    }
    public void enterTextInTheSearchField(String product){
        WebElement emailFieldElement = driver.findElement(searchField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        emailFieldElement.clear();
        emailFieldElement.sendKeys(product);
    }
    public void clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).isEnabled();
        driver.findElement(searchButton).click();
    }
    public void checkResultsWithProduct(String product){
        WebElement element = driver.findElement(searchField);
        wait.until(ExpectedConditions.visibilityOfElementLocated(results));
        String text = element.getText();
        Assertions.assertTrue(text.contains(product));
    }
    public void checkExistingButtons() {
        boolean allProductsHaveButton = checkProductsForButtonsPresence(productList);

        if (!allProductsHaveButton) {
            fail("Не все продукты содержат кнопку.");
        }
    }
    private boolean checkProductsForButtonsPresence(List<WebElement> productArray) {
        boolean allProductsHaveButton = true;

        for (WebElement product : productArray) {
            WebElement addButtonElement = product.findElement(addButtons);
            boolean isAddButtonPresent  = addButtonElement.isDisplayed();

            if (!isAddButtonPresent) {
                allProductsHaveButton = false;
                break;
            }
        }
        return allProductsHaveButton;
    }
}
