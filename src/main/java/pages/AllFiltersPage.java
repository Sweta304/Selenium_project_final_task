package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class AllFiltersPage extends BasePage {


    @FindBy(xpath = "//div[@data-filter-id='glprice']//div[@data-prefix='от']//input")
    public WebElement priceFrom;

    @FindBy(xpath = "//h4[text()='Цвет']")
    public WebElement color;

    @FindBy(xpath = "//h4[contains(text(),'Производитель')]")
    public WebElement producerButton;

    @FindBy(xpath = "//button[@class='zsSJk dOdmr _1QJa9']")
    public WebElement showMoreButton;

    @FindBy(xpath = "//div[@data-filter-id='7893318']")
    public WebElement producerMenu;

    public void chooseProducer(String producerName) {
        BaseSteps.getDriver().findElement(By.xpath("//div[text()='" + producerName + "']")).click();
    }

    @FindBy(xpath = "//a[contains(text(),'предложений')]")
    public WebElement filterApply;

    List<WebElement> resultsList;

    public int searchResultsFromFilter() {
        String filterApplyButtonName = filterApply.getText();
        int searchResults = Integer.parseInt(filterApplyButtonName.replaceAll("[^\\d]", ""));
        return searchResults;
    }

    public int searchResultCounter() {
        resultsList = BaseSteps.getDriver().findElements(By.xpath("//div[@aria-label='Результаты поиска']//h3//span[@data-tid]"));
        int count = resultsList.size();
        return count;

    }

    public String certainSearchResult(int resultNo) {
        String certainSearchResult = String.valueOf((resultsList.get(resultNo)).getText());
        return certainSearchResult;
    }

    @FindBy(xpath = "//input[@id='header-search']")
    public WebElement searchPlaceholder;

    @FindBy(xpath = "//span[contains(text(),'Найти')]")
    public WebElement searchButton;

    public boolean isElementPresent(String productName) {
        int productsQty = BaseSteps.getDriver().findElements(By.xpath("//a[@title='" + productName + "']")).size();
        boolean isPresent=(productsQty>0);
        return isPresent;
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "цена":
                fillField(priceFrom, value);
                break;
        }
    }

    public AllFiltersPage()  {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

}