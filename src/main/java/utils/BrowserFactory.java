package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by shweta on 20/09/2017.
 */
public class BrowserFactory {

    public static WebDriver driver;

    public static void openBrowser() {
        String url ="https://www.zopa.com/";
        String browser = "chrome";

        if (browser.matches("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/browser/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.matches("chrome")) {
            try {
                System.setProperty("webdriver.chrome.driver", "src/main/browser/chromedriver.exe");
                driver = new ChromeDriver();
            } catch (Exception e) {

                System.out.println("Browser did not load");

            }
        }

        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    public static WebDriver getDriver(){
        return driver;
    }

    public static void stopBrowser(){
        driver.close();
    }
}
