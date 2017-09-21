
import com.Zopa.DashboardPage;
import com.Zopa.HomePage;
import com.Zopa.RegisterPage;
import org.junit.Assert;
import org.junit.Test;
import utils.TestData;
import utils.UtilityClass;

import java.io.IOException;

/**
 * Created by shweta on 20/09/2017.
 */
public class E2E extends BaseTest {

    DashboardPage dashboardPage = new DashboardPage();
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    TestData testData = new TestData();
    UtilityClass utilityClass = new UtilityClass();

    //This test is for all positive data and delete address
    @Test
    public void userRegister() throws IOException {
        homePage.gotoDashboardPage();
        dashboardPage.gotoRegisterPage();
        registerPage.getQuote();
        registerPage.doRegistration(testData.emailAddr, testData.firstName, testData.lastName, testData.phone, testData.birthDay, testData.addrMonth, testData.birthYear, testData.postCode, testData.address, testData.addrMonth, testData.addrYear, testData.annualIncome, testData.rentContribution, testData.pwd);
        registerPage.deleteAddress();
        Assert.assertFalse(utilityClass.isTextPresent("51 BEDFORD ROAD  IG1 1EL  ILFORD ESSEX"));

    }

    @Test
    public void userRegisterWith2Addr() throws IOException, InterruptedException {//This test is for all positive data and add two address
        homePage.gotoDashboardPage();
        dashboardPage.gotoRegisterPage();
        registerPage.doRegistration(testData.emailAddr, testData.firstName, testData.lastName, testData.phone, testData.birthDay, testData.addrMonth, testData.birthYear, testData.postCode, testData.address, testData.addrMonth, testData.addrYear, testData.annualIncome, testData.rentContribution, testData.pwd);
        registerPage.showPassword(testData.pwd);
        registerPage.addAnotherAddress(testData.newPostCode, testData.newAddress, testData.newAddrMonth, testData.newAddrYear);
        Assert.assertTrue(utilityClass.isTextPresent("51 BEDFORD ROAD  IG1 1EL  ILFORD ESSEX"));
        Assert.assertTrue(utilityClass.isTextPresent("52 BEDFORD ROAD  IG1 1EL  ILFORD ESSEX"));

    }

    //This test is for invalid test data
    @Test
    public void invalidDataRegister() throws IOException, InterruptedException {
        homePage.gotoDashboardPage();
        dashboardPage.gotoRegisterPage();
        registerPage.doRegistration(testData.invalidEmailAddr, testData.invalidFName, testData.lastName, testData.invalidPhone, testData.birthDay, testData.addrMonth, testData.birthYear, testData.postCode, testData.address, testData.addrMonth, testData.invalidAddrYear, testData.annualIncome, testData.rentContribution, testData.pwd);
        Assert.assertFalse(registerPage.isAddressValid());
        Assert.assertFalse(registerPage.isValidEmailAddress());
        Assert.assertFalse(registerPage.isNameValid());
        Assert.assertFalse(registerPage.isValidPhoneNumber());

    }

    //This test is to remove address
    @Test
    public void deleteAddress() throws IOException {
        homePage.gotoDashboardPage();
        dashboardPage.gotoRegisterPage();
        registerPage.getQuote();
        registerPage.doRegistration(testData.emailAddr, testData.firstName, testData.lastName, testData.phone, testData.birthDay, testData.addrMonth, testData.birthYear, testData.postCode, testData.address, testData.addrMonth, testData.addrYear, testData.annualIncome, testData.rentContribution, testData.pwd);
        registerPage.deleteAddress();
        Assert.assertFalse(utilityClass.isTextPresent("51 BEDFORD ROAD  IG1 1EL  ILFORD ESSEX"));

    }

}
