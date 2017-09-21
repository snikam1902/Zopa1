package com.Zopa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.UtilityClass;

import java.io.IOException;

/**
 * Created by shweta on 20/09/2017.
 */
public class HomePage extends BasePage {
    UtilityClass utilityClass = new UtilityClass();

    @FindBy(how = How.LINK_TEXT, using = "Get a Zopa loan")
    public WebElement zopaLoanButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage gotoDashboardPage() throws IOException {
        try {
            zopaLoanButton.click();
        } catch (Exception e) {
            e.printStackTrace();
            utilityClass.captureScreenshot("failedToNavigate");
        }
        return this;
    }
}
