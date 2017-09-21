package com.Zopa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.UtilityClass;

/**
 * Created by shweta on 20/09/2017.
 */
public class DashboardPage extends BasePage {


    @FindBy(how = How.CSS, className = "calculator__quoteContainer")
    public WebElement calculateRate;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }


    public DashboardPage gotoRegisterPage() {
        calculateRate.click();
        return this;
    }


}
