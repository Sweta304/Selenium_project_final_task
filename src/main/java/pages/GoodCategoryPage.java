package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class GoodCategoryPage extends BasePage{
    @FindBy(xpath="//*[contains(text(),'Все фильтры')]")
    public WebElement allFilters;

    public GoodCategoryPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }


}
