package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class YaMainPage extends BasePage{
    @FindBy(xpath="//a[@data-statlog='services_new.promo.market']")
    public WebElement mainMenuMarket;

    public YaMainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
