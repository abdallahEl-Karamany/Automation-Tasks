import Actions.BrowserActions;
import POM.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class HomePageTest {


    HomePage home;


    @BeforeTest
    public void homeTest() {
        BrowserActions.webDriverInit();
        BrowserActions.windowMaximize();
        home = new HomePage();
        home.homeNavigation();
    }


    @AfterTest
    public void tearDown() {
        BrowserActions.closeBrowser();
    }

}
