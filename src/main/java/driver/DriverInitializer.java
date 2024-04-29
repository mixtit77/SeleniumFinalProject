package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public  class DriverInitializer {

//    public static WebDriver initalizeDriver(BrowserType browserType) {
//        if (browserType == BrowserType.CHROME) {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--disable-blink-features=AutomationControlled");
//            return new ChromeDriver();
//        } else {
//            return new FirefoxDriver();
//        }
//    }
public static WebDriver initChrome() {
    return initDriver(BrowserType.CHROME);
}

    public static WebDriver initDriver(BrowserType type) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-notifications");
        //options.addArguments("window-size=1980,1080");
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }

}
