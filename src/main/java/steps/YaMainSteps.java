package steps;

import io.qameta.allure.Step;
import pages.YaMainPage;

public class YaMainSteps {
    @Step("Выполняет переход на Яндекс.Маркет")
    public void goToMarket (){
        new YaMainPage().mainMenuMarket.click();
    }
}
