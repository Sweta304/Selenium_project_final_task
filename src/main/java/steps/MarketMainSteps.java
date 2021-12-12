package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MarketMainPage;


public class MarketMainSteps {

    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);

    @Step("Переходит в раздел Электроника")
    public void goToElectronics (){
        new BaseSteps().tabsSwitcher(1);
        wait.until(ExpectedConditions.visibilityOf(new MarketMainPage().electronics));
        new MarketMainPage().electronics.click();
    }
}
