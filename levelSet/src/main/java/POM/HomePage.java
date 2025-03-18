package POM;

import Actions.ElementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class HomePage {
     WebDriver driver;

    String HomeURL="https://www.levelset.com/";


    String getPaid="//li[@class='top-level-link ml-sm-05 mr-sm-05 relative ml-0']/a[@class='btn btn-info btn-outline mob-dropdown-btn']";

    ElementActions act;
    public HomePage(WebDriver driver){

        this.driver=driver;
         act=new ElementActions(driver);
    }


    public void homeNavigation(){

        By expectedElement= By.xpath(getPaid);
        act.navigation(HomeURL,expectedElement,20);
    }

    public SelectDoc clickElement(){
        By element=By.xpath(getPaid);
        By expectedElement=By.xpath(String.format(new SelectDoc(driver).freeDocs,"Exchange a Waiver"));
        try{
            act.clickOnElement(element,expectedElement,20);
        } catch (Exception e) {
           act.sendKeyBoardKeys("enter",element,expectedElement,20);
        }
        return new SelectDoc(driver);
    }





}