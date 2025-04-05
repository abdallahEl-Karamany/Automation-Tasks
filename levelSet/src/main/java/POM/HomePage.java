package POM;

import Actions.ElementActions;

public class HomePage {


    String HomeURL = "https://www.levelset.com/";


    String getPaid = "//ul[@class='main-nav-ul']//a[contains(text(),'%s')]";

    ElementActions act;

    public HomePage() {

        act = new ElementActions();
    }


    public void homeNavigation() {

        String expectedSelector = String.format(getPaid, "Get paid ");
        act.PageNavigation(HomeURL, ElementActions.Locator.xPath,expectedSelector, 50);
    }

    public SelectDoc clickElement() {
        String elementSelector =String.format(getPaid, "Get paid ");
        String expectedSelector = String.format(new SelectDoc().freeDocs, "Free", "Exchange a Waiver");
        try {
            act.clickOnElement(ElementActions.Locator.xPath,elementSelector, ElementActions.Locator.xPath,expectedSelector, 50);
        } catch (Exception e) {
            act.sendKeyBoardKeys(ElementActions.SupportedKeys.ENTER, ElementActions.Locator.xPath,elementSelector,  ElementActions.Locator.xPath,expectedSelector, 50);
        }
        return new SelectDoc();
    }


}