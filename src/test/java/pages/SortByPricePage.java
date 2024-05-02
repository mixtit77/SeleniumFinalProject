package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortByPricePage extends BasePage {
    private static final By promotionsSection = By.xpath("//*[@class=\"nav-item__link nav-item__link--right-aligned\" and contains(text(), \"Promotions\")]");
    private static final By promotionsHeader = By.id("promotions");
    private static final By sortBy = By.xpath("//*[@class=\"filter-select sort-control icon\"]");
    private static final By priceDescending = By.xpath("//option[@value='price-descending']");
    private static final By priceAscending = By.xpath("//option[@value='price-ascending']");
    private static final By resultsPrice = By.xpath("(//*[@class=\"styled__StyledHeading-sc-119w3hf-2 jWPEtj styled__Text-sc-8qlq5b-1 lnaeiZ beans-price__text\"])");


    private static final By suggestedSectionsLocator = By.xpath("//*[@class=\"name\"]");

    public SortByPricePage(WebDriver driver) {
        super(driver);
    }

    public void goToThePromotionSection() {
        wait.until(ExpectedConditions.elementToBeClickable(promotionsSection)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(promotionsHeader));
    }

    public void goToAnySuggestedSection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(suggestedSectionsLocator));
        List<WebElement> suggestedSections = driver.findElements(suggestedSectionsLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(promotionsHeader));
        if (suggestedSections.isEmpty()) {
            throw new RuntimeException("No suggested sections found");
        }
        Random rand = new Random();
        int randomIndex = rand.nextInt(suggestedSections.size());
        WebElement randomSection = suggestedSections.get(randomIndex);
        randomSection.click();
    }

    public void clickOnSortByHighToLow() {
        wait.until(ExpectedConditions.elementToBeClickable(sortBy)).click();
        wait.until(ExpectedConditions.elementToBeClickable(priceDescending)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sortBy));
    }

    public void clickOnSortByLowToHigh() {
        wait.until(ExpectedConditions.elementToBeClickable(sortBy)).click();
        wait.until(ExpectedConditions.elementToBeClickable(priceAscending)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sortBy));
    }

    public void checkSortedByHighToLowResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsPrice));
        List<WebElement> resultPrices = driver.findElements(resultsPrice);

        List<Double> prices = new ArrayList<>();
        for (WebElement element : resultPrices) {
            String priceText = element.getText().replaceAll("[^\\d.]", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                throw new AssertionError("Price " + prices.get(i) + " is not greater than " + prices.get(i + 1));
            }
        }

    }

    public void checkSortedByLowToHighResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(resultsPrice));
        List<WebElement> resultPrices = driver.findElements(resultsPrice);

        List<Double> prices = new ArrayList<>();
        for (WebElement element : resultPrices) {
            String priceText = element.getText().replaceAll("[^\\d.]", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                throw new AssertionError("Price " + prices.get(i) + " is not less than " + prices.get(i + 1));
            }
        }
    }

}
