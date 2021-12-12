package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class MarketMainPage extends BasePage{
    @FindBy(xpath="//span[contains(text(),'Электроника')]")
    public static WebElement electronics;

    public MarketMainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
