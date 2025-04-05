package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActions {

    public static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static void webDriverInit(){
        driver.set(new ChromeDriver());
    }
    public static void windowMaximize(){
        driver.get().manage().window().maximize();
    }
    public static void closeBrowser(){
        driver.get().quit();
    }


}
