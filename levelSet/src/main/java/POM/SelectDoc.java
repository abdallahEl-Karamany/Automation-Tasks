package POM;

import Actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SelectDoc {
     WebDriver driver;

    String docsByPrices="//span[@class=\"price-amount\" and  number(translate(.,'$', '')) > %s  and  number(translate(.,'$', '')) " +
            "< %s]//parent::div//parent::div//child::div[@class=\"left\"]",

    freeDocs=" //span[contains(text(),'%s')]//parent::div//parent::div//child::div[@class=\"left\" and contains(text(),'%s')]";
    ElementActions act;

    public SelectDoc(WebDriver driver)
    {
        this.driver=driver;
         act=new ElementActions(driver);

    }
    public List<WebElement> getFreeDocs(){
        By elements=By.xpath(String.format(freeDocs,"Free",""));
         return act.getElements(elements);
    }
    public String freeDocText(String text){
        By elements=By.xpath(String.format(freeDocs,"Free",text));
        return act.getElementText(elements);
    }
    public List<WebElement> getDocsWithPrice(String minPrice,String maxPrice){
        By elements=By.xpath(String.format(docsByPrices,minPrice,maxPrice));
        return act.getElements(elements);
    }

    public List<String> getPricedText(String minPrice,String maxPrice){
        By elements=By.xpath(String.format(docsByPrices,minPrice,maxPrice));
        return act.getAllElementText(elements);
    }

}
