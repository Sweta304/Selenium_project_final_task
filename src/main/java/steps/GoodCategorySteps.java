package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GoodCategoryPage;
import pages.MarketMainPage;

public class GoodCategorySteps {

    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);

    @Step("Переходит в расширенный фильтр")
    public void expandFilter(){
        wait.until(ExpectedConditions.visibilityOf(new GoodCategoryPage().allFilters));
        new GoodCategoryPage().allFilters.click();
    }
}
