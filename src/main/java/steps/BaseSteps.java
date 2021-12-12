package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestProperties;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class BaseSteps {

    protected static WebDriver driver;
    public static Properties properties = TestProperties.getInstance().getProperties();
    protected static String baseUrl;
    public static WebDriver getDriver() {
        return driver;
    }
    public static int searchRes;

    @Before
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();

        baseUrl=properties.getProperty("app.url");
        driver.get(baseUrl);
        //ожидание 30 секунд
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //развернуть окно браузера
        driver.manage().window().maximize();
    }

    @After
    public static void tearDown() throws Exception {
        //закрыть браузер
        driver.quit();
    }

    protected void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    protected void checkFillField(String value, WebElement element) {
        assertEquals(value, element.getAttribute("value"));
    }

    public void checkError(String value, WebElement element) {
        assertEquals(value, element.getText());
    }

    public void tabsSwitcher (int tabNo) {
        ArrayList<String> tabs2 = new ArrayList<String>(BaseSteps.getDriver().getWindowHandles());
        BaseSteps.getDriver().switchTo().window(tabs2.get(tabNo));
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
