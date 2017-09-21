package utils;

import com.Zopa.BasePage;
import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


/**
 * Created by shweta on 19/09/2017.
 */
public class UtilityClass extends BrowserFactory {

    WebDriver driver = BrowserFactory.getDriver();


    public UtilityClass selectByVisibleText(WebElement element, String value) {
        Select selectByText = new Select(element);
        selectByText.selectByVisibleText(value);
        return this;
    }

    public UtilityClass selectByIndex(WebElement element, int index) {
        Select selectIndex = new Select(element);
        selectIndex.selectByIndex(index);
        return this;
    }

    public String getText(WebElement element) {
        return element.getText();
    }


    public boolean isTextPresent(String text) {
        if (driver.getPageSource().contains(text)) {
            System.out.println("Text present");
            return true;
        } else {
            System.out.println("Text is not present");
            return false;
        }
    }


    public String waitForElement(String item) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name(item)));
        return item;
    }

    public String waitForElements(String items) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(items)));
        return items;
    }

    public void hover(WebElement hover) {
        Actions actions =  new Actions(driver);
        actions.moveToElement(hover).click().perform();
    }


    public void captureScreenshot(String screenshotName) throws IOException {
        try {

            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceScreenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            System.out.println("The current url is:" + driver.getCurrentUrl());
            File destinationScreenShot = new File("src/test/resources/Screenshots/" + screenshotName + ".png");
            FileUtils.copyFile(sourceScreenshot, destinationScreenShot);
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }

    }
}
