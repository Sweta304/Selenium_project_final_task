package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AllFiltersPage;
import pages.GoodCategoryPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class AllFiltersSteps {

    Wait<WebDriver> wait = new WebDriverWait(BaseSteps.getDriver(), 5, 1000);
    AllFiltersPage allFiltersPage = new AllFiltersPage();



    @Step("Устанавливает цену от {0}")
    public void priceFrom (String price){
        allFiltersPage.fillField("цена",price);
    }

    @Step("Выбирает производителя {0}")
    public void chooseProducer(String producerName){
        ((JavascriptExecutor) BaseSteps.getDriver()).executeScript("arguments[0].scrollIntoView();", allFiltersPage.color);
        allFiltersPage.showMoreButton.click();
        allFiltersPage.chooseProducer(producerName);
    }

    @Step("Применяет фильтр")
    public void applyButton (){
        BaseSteps.getDriver().manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
        BaseSteps.searchRes = allFiltersPage.searchResultsFromFilter();
        allFiltersPage.filterApply.click();
    }

    @Step("Проверяет кол-во выведенных результатов поиска")
    public void correctResultsQty (){
        wait.until(ExpectedConditions.visibilityOf(new GoodCategoryPage().allFilters));
        BaseSteps.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        int actualResult = allFiltersPage.searchResultCounter();
        int expectedResult = BaseSteps.searchRes;
        //int expectedResult = 25;
        assertTrue(String.format("Кол-во найденных результатов [%s]. Ожидалось - [%s]", actualResult, expectedResult), (actualResult==expectedResult));
    }

    @Step("Вводит в поисковую строку первый элемент в списке результатов поиска")
    public void searching (){
        allFiltersPage.fillField(allFiltersPage.searchPlaceholder, allFiltersPage.certainSearchResult(0));
        allFiltersPage.searchButton.click();
    }

    @Step("Проверяет, что наименование товара соответствует заданному значению")
    public void goodIsInResultList (){
        assertTrue(allFiltersPage.isElementPresent(allFiltersPage.certainSearchResult(0)));
    }

}
