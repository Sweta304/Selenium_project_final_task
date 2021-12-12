package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

public class ElectronicsPage extends BasePage{
    @FindBy(xpath="//a[text()='Телевизоры']")
    public WebElement tv;

    @FindBy(xpath="//a[text()='Наушники и Bluetooth-гарнитуры']")
    public WebElement earphones;

    public ElectronicsPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }
}
