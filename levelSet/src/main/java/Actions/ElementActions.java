package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class ElementActions {
     WebDriver driver;

    public ElementActions(WebDriver driver){
        this.driver=driver;

    }
    public void navigation(String URL,By element ,long duration){
        driver.get(URL);
        elementValidation("present", element,duration);


    }

    //I think this method should be implemented in a wrapper class

    public boolean elementValidation(String validationType,By element,long duration){
        ExpectedCondition<WebElement> type=null;
        switch (validationType){
            case"present":
                type=ExpectedConditions.presenceOfElementLocated(element);
                break;
            case "clickable":
                type=ExpectedConditions.elementToBeClickable(element);
                break;
            case "visible":
                type=ExpectedConditions.visibilityOfElementLocated(element);
                break;
        }

        try{
            new WebDriverWait(driver, Duration.ofMillis(duration))
                    .until(type);
        }
        catch(Exception e){
            new WebDriverWait(driver, Duration.ofMillis(duration)).until(type);
             if(type==null)
            {
                return false;
            }
        }
        return true;
    }


    public void clickOnElement(By element,By expectedElement,long duration){
        if(elementValidation("clickable",element,duration)){
            getElement(element).click();
            elementValidation("present",expectedElement,duration);

            }
        }

    public void sendKeyBoardKeys(String key,By element,By expectedElement,long duration){
          key =key.toUpperCase();
        Keys keys;
        switch(key){
            case "ENTER":
               keys=Keys.valueOf(key);
                break;
        }
        if(elementValidation("visible",element,duration)){
            getElement(element).sendKeys(key);
            elementValidation("present",expectedElement,duration);
            }


    }

    public WebElement getElement(By element){
        return driver.findElement(element);
    }

    public List<WebElement> getElements(By element){
        return driver.findElements(element);
    }

    public String getElementText(By element){
        return getElement(element).getText();
    }

    public List<String> getAllElementText(By element){
        List<WebElement> elementList=getElements(element);
        List<String> textList=new ArrayList<>();
        for(WebElement list:elementList){
            textList.add(list.getText());
        }
        return textList;
    }





}
