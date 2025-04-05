package POM;

import Actions.ElementActions;
import java.util.List;

public class SelectDoc {


    String docsByPrices = "//span[@class=\"price-amount\" and  number(translate(.,'$', '')) > %s  and  number(translate(.,'$', '')) " + "< %s]//parent::div//parent::div//child::div[@class=\"left\"]",

    freeDocs = " //span[contains(text(),'%s')]//parent::div//parent::div//child::div[@class=\"left\" and contains(text(),'%s')]";
    ElementActions act;

    public SelectDoc() {
        act = new ElementActions();

    }

    public int getFreeDocs() {
        String  elementSelectors = String.format(freeDocs, "Free", "");
        return act.getElements(ElementActions.Locator.xPath,elementSelectors).size();
    }

    public String freeDocText(String text) {
        String elementSelectors = String.format(freeDocs, "Free", text);
        return act.getElementText(ElementActions.Locator.xPath,elementSelectors);
    }

    public int getDocsWithPrice(String minPrice, String maxPrice) {
        String elementSelectors = String.format(docsByPrices, minPrice, maxPrice);
        return act.getElements(ElementActions.Locator.xPath,elementSelectors).size();
    }

    public List<String> getPricedText(String minPrice, String maxPrice) {
        String elementSelectors = String.format(docsByPrices, minPrice, maxPrice);
        return act.getAllElementText(ElementActions.Locator.xPath,elementSelectors);
    }

}
