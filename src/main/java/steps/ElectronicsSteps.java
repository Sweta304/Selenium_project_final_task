package steps;

import io.qameta.allure.Step;
import pages.ElectronicsPage;

public class ElectronicsSteps {

    @Step("Переходит в раздел {0}")
    public void goToCategory(String category){
        ElectronicsPage electronicsPage = new ElectronicsPage();
        switch(category){
            case "наушники":
                electronicsPage.earphones.click();
                break;
            case "телевизоры":
                electronicsPage.tv.click();
                break;
        }
    }
}
