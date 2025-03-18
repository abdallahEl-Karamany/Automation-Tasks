package POM;

import Actions.ElementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class HomePage {
     WebDriver driver;

    String HomeURL="https://www.levelset.com/";


    String getPaid="//ul[@class='main-nav-ul']//a[contains(text(),'%s')]";

    ElementActions act;
    public HomePage(WebDriver driver){

        this.driver=driver;
         act=new ElementActions(driver);
    }


    public void homeNavigation(){

        By expectedElement= By.xpath(String.format(getPaid,"Get paid "));
        act.navigation(HomeURL,expectedElement,50);
    }

    public SelectDoc clickElement(){
        By element=By.xpath(String.format(getPaid,"Get paid "));
        By expectedElement=By.xpath(String.format(new SelectDoc(driver).freeDocs,"Free","Exchange a Waiver"));
        try{
            act.clickOnElement(element,expectedElement,50);
        } catch (Exception e) {
           act.sendKeyBoardKeys("enter",element,expectedElement,50);
        }
        return new SelectDoc(driver);
    }





}