import POM.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class HomePageTest {

    WebDriver driver;
     HomePage home;


    @BeforeTest
    public void homeTest(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        home = new HomePage(driver);
    }
    @BeforeClass
    public void navigation(){
        home.homeNavigation();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
