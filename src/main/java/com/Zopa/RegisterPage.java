package com.Zopa;

import org.apache.commons.validator.routines.EmailValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.TestData;
import utils.UtilityClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by shweta on 20/09/2017.
 */
public class RegisterPage extends BasePage {
    TestData testData = new TestData();
    UtilityClass utilityClass = new UtilityClass();

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "#member_email")
    public WebElement emailField;
    @FindBy(how = How.CSS, using = "#applications_loan_apply_title_mr")
    public WebElement title;
    @FindBy(how = How.CSS, using = "#applications_loan_apply_first_name")
    public WebElement firstNameField;
    @FindBy(how = How.CSS, using = "#applications_loan_apply_home_phone")
    public WebElement phoneField;
    @FindBy(how = How.CSS, using = "#applications_loan_apply_last_name")
    public WebElement lastNameField;
    @FindBy(how = How.ID, using = "date_of_birth_day")
    public WebElement birthDayField;
    @FindBy(how = How.ID, using = "date_of_birth_month")
    public WebElement birthMonthField;
    @FindBy(how = How.ID, using = "date_of_birth_year")
    public WebElement birthYearField;
    @FindBy(how = How.CSS, using = "#applications_loan_apply_loan_purpose_car")
    public WebElement loanPurpose;
    @FindBy(how = How.CSS, using = "#address_postcode")
    public WebElement postcodeField;
    @FindBy(how = How.NAME, using = "find_address")
    public WebElement lookUpAddressButton;
    @FindBy(how = How.NAME, using = "address[possible_address]")
    public WebElement addressField;
    @FindBy(how = How.NAME, using = "address[from(2i)]")
    public WebElement addressMonth;
    @FindBy(how = How.NAME, using = "address[from(1i)]")
    public WebElement addressYear;
    @FindBy(how = How.NAME, using = "select_address")
    public WebElement useAddrButton;
    @FindBy(how = How.CSS, using = "#applications_loan_apply_employment_status_employed_full_time")
    public WebElement employmentStatusFLTime;
    @FindBy(how = How.CSS, using = "#applications_loan_apply_salary")
    public WebElement annualIncomeField;
    @FindBy(how = How.CSS, using = "#applications_loan_apply_residential_status_owner_with_mortgage")
    public WebElement residentialStatusOwnerWtMordgage;
    @FindBy(how = How.CSS, using = "#applications_loan_apply_rent")
    public WebElement rentContributionField;
    @FindBy(how = How.CSS, using = "#member_password")
    public WebElement passwordField;
    @FindBy(how = How.CSS, using = ".bunch")
    public WebElement quoteText;
    @FindBy(how = How.CSS, using = "#show_password")
    public WebElement showPwdCheckBox;
    @FindBy(how = How.LINK_TEXT, using = "Add another address")
    public WebElement addAnotherAddrLink;
    @FindBy(how = How.CSS, using = ".instruction")
    public WebElement instructionText;
    @FindBy(how = How.XPATH, using = "//input[@value = 'Remove']")
    public WebElement removeButton;

    public RegisterPage doRegistration(String email, String fname, String lastName, String phone, String birthday, String birthMonth, String birthYear, String postcade, int index, String addrsMonth, String addrYear, String annualIncome, String rentContribution, String pwd) throws IOException {

        try {
            emailField.sendKeys(email);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            utilityClass.hover(title);
            firstNameField.sendKeys(fname);
            lastNameField.sendKeys(lastName);
            phoneField.sendKeys(phone);
            birthDayField.sendKeys(birthday);
            birthMonthField.sendKeys(birthMonth);
            birthYearField.sendKeys(birthYear);
            utilityClass.hover(loanPurpose);
            postcodeField.sendKeys(postcade);
            lookUpAddressButton.click();
            utilityClass.waitForElement("select_address");
            utilityClass.selectByIndex(addressField, index);
            utilityClass.selectByVisibleText(addressMonth, addrsMonth);
            utilityClass.selectByVisibleText(addressYear, addrYear);
            useAddrButton.click();
            utilityClass.waitForElements(".minor.secondary");
            utilityClass.hover(employmentStatusFLTime);
            annualIncomeField.sendKeys(annualIncome);
            utilityClass.hover(residentialStatusOwnerWtMordgage);
            rentContributionField.sendKeys(rentContribution);
            passwordField.sendKeys(pwd);
        } catch (Exception e) {
            e.printStackTrace();
            utilityClass.captureScreenshot("failedToRegister");
        }
        return this;
    }


    public RegisterPage getQuote() {
        String quote = quoteText.getText();
        System.out.println(quote);
        return this;
    }

    public boolean showPassword(String pwd) {
        utilityClass.hover(showPwdCheckBox);
        String password = passwordField.getText();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (password.equals(pwd)) {
            return true;
        } else {
            return false;
        }

    }


    public RegisterPage addAnotherAddress(String anotherPostcode, int index, String addrsMonth, String addrYear) throws InterruptedException, IOException {
        try {
            addAnotherAddrLink.click();
            postcodeField.sendKeys(anotherPostcode);
            lookUpAddressButton.click();
            utilityClass.waitForElement("select_address");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            utilityClass.selectByIndex(addressField, index);
            utilityClass.selectByVisibleText(addressMonth, addrsMonth);
            utilityClass.selectByVisibleText(addressYear, addrYear);
            driver.findElement(By.name("select_address")).click();
            utilityClass.waitForElements(".minor.secondary");
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            utilityClass.captureScreenshot("failedToAdd2ndAddr");
        }

        return this;
    }

    //This method is to check address is used for last 3 years
    public boolean isAddressValid() {
        String addr = instructionText.getText();

        if (addr.contains("We need your UK address history for the last 3 years.")) {
            System.out.println("Enter proper address");
            return false;
        } else {
            return true;
        }
    }

    public RegisterPage deleteAddress() {//This method is to delete address
        utilityClass.hover(removeButton);
        return this;
    }

    //This method is to check phone number is uk
    public boolean isValidPhoneNumber() {
        String phoneNumber = utilityClass.getText(phoneField);
        if (phoneNumber.startsWith("+44")) {
            return true;
        } else {
            System.out.println("Enter UK phone number");
            return false;
        }
    }

    //This method is to check enetr name is valid or not
    public boolean isNameValid() {
        String name = firstNameField.getText();
        int nameLength = name.length();
        if (nameLength > 2) {
            return true;
        } else {

            System.out.println("Enter right name");
            return false;
        }
    }

    //This method is to check entered email is valid
    public boolean isValidEmailAddress() {
        String email = utilityClass.getText(emailField);
        boolean valid = EmailValidator.getInstance().isValid(email);

        if (valid == true) {
            return true;
        } else {
            System.out.println("Invalid email address");
            return false;
        }
    }

}
