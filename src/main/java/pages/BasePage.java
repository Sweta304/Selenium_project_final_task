package pages;

import org.openqa.selenium.WebElement;
import steps.BaseSteps;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BasePage {

    public void fillField(WebElement element, String value) {
        element.click();
        element.clear();
        element.click();
        element.sendKeys(value);
    }

    public void tabsSwitcher (int tabNo) {
        ArrayList<String> tabs2 = new ArrayList<String>(BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(tabs2.get(tabNo));
    }

    public void checkFillField(String value, WebElement element) {
        assertEquals(value, element.getAttribute("value"));
    }
    public void checkError(String value, WebElement element) {
        assertEquals(value, element.getText());
    }
}
