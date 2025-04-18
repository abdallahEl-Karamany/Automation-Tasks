package Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActions {

    public static ThreadLocal<WebDriver> driver=new ThreadLocal<>();

    public static void webDriverInit(browser Browser){

        switch (Browser){
            case chrome:driver.set(new ChromeDriver());
                break;
            case edge:driver.set(new EdgeDriver());
                break;
            case firefox:driver.set(new FirefoxDriver());
            break;
        }
    }
    public static void windowMaximize(){
        driver.get().manage().window().maximize();
    }
    public static void closeBrowser(){
        driver.get().quit();
    }


    public enum browser{
        chrome,
        edge,
        firefox


    }


}
