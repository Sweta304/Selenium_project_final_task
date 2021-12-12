package steps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioSteps {

    YaMainSteps yaMainSteps = new YaMainSteps();
    MarketMainSteps marketMainSteps = new MarketMainSteps();
    ElectronicsSteps electronicsSteps = new ElectronicsSteps();
    GoodCategorySteps goodCategorySteps = new GoodCategorySteps();
    AllFiltersSteps allFiltersSteps = new AllFiltersSteps();


    @When("^Выполнен переход на Яндекс.Маркет$")
    public void goToMarketCu (){
        yaMainSteps.goToMarket();
    }

    @When("^Выполнен переход в раздел Электроника$")
    public void goToElectronicsCu (){
        marketMainSteps.goToElectronics();
    }

    @When("^Выполнен переход в раздел \"(.+)\"$")
    public void goToCategoryCu(String category){
        electronicsSteps.goToCategory(category);
    }

    @When("^Выполнен переход к расширенному фильтру$")
    public void expandFilterCu(){
        goodCategorySteps.expandFilter();
    }

    @When("^Установлена цена от \"(.+)\"$")
    public void priceFromCu (String price){
        allFiltersSteps.priceFrom(price);
    }

    @When("^Выбран производитель \"(.+)\"$")
    public void chooseProducerCu (String producer){
        allFiltersSteps.chooseProducer(producer);
    }

    @When("^Фильтр применен$")
    public void applyButtonCu (){
        allFiltersSteps.applyButton();
    }

    @Then("^Проверяет кол-во выведенных результатов поиска$")
    public void correctResultsQtyCu (){
        allFiltersSteps.correctResultsQty();
    }

    @When("^Вводит в поисковую строку первый элемент в списке результатов поиска$")
    public void searchingCu (){
        allFiltersSteps.searching();
    }

    @Then("^Проверяет, что наименование товара соответствует заданному значению$")
    public void goodIsInResultListCu (){
        allFiltersSteps.goodIsInResultList();
    }

}
