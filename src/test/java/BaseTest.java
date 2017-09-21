import com.Zopa.BasePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

/**
 * Created by shweta on 19/09/2017.
 */
public class BaseTest extends BasePage {

    static WebDriver driver;

    BasePage basePage = new BasePage();




    @BeforeClass
    public static void setUp()
    {
        BrowserFactory.openBrowser();
        driver= BrowserFactory.getDriver();
    }



    @AfterClass
    public static void tearDown()
    {
        BrowserFactory.stopBrowser();
    }

}
