package utils;

import org.openqa.selenium.Keys;

import java.security.Key;
import java.util.Random;

/**
 * Created by shweta on 20/09/2017.
 */
public class TestData {

    public String emails = new Random().nextInt() + "terrr";

    public String firstName = "Rajesh";
    public String lastName = "Patil";
    public String phone = "+44 9897878633";
    public String birthDay = "12";
    public String birthmonth = "08";
    public String birthYear = "1986";
    public String postCode = "IG11EL";
    public int address = 1;
    public String addrMonth = "March";
    public String addrYear = "2013";
    public String annualIncome = "30000";
    public String rentContribution = "500";
    public String pwd = "password";
    public String emailAddr = new Random().nextInt() + "test@yahoo.com";


    public String newPostCode = "IG11EL";
    public int newAddress = 2;
    public String newAddrMonth = "March";
    public String newAddrYear = "2012";

    //Test data for negative value

    public String invalidPhone = "9897878633";

    public String invalidFName = "A" ;

    public String invalidAddrYear = "2016";

    public String invalidEmailAddr = new Random().nextInt() + "testahoo.com";


}
