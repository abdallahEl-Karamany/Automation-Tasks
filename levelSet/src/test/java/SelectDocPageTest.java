import POM.SelectDoc;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDocPageTest extends HomePageTest {
    SelectDoc selectDoc;
    List<String> textList;

    @Test
    public void freeDocTest() {
        selectDoc = home.clickElement();
        Assert.assertEquals(selectDoc.getFreeDocs(), 2, "Count of free Docs is  not Correct");
        Assert.assertEquals(selectDoc.freeDocText("Exchange a Waiver"), "Exchange a Waiver", "Expected Text is (Exchange a Waiver)");
        Assert.assertEquals(selectDoc.freeDocText("Send a Payment Document"), "Send a Payment Document", "Expected text is (Send a Payment Document) ");

    }

    @Test
    public void pricedDocsTest() {
        Assert.assertEquals(selectDoc.getDocsWithPrice("30", "60"), 1, "Count of priced Docs Expected to be 1");
        textList = selectDoc.getPricedText("30", "60");
        Assert.assertTrue(textList.contains("Send a Warning"), "Expected Text is Send a Warning");
    }

}
