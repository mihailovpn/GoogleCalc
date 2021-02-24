package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CalcPage;
import pages.DetailsPage;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleCalc {
    private static WebDriver driver;
    private static SearchPage searchPage;
    private static CalcPage calcPage;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
        calcPage = new CalcPage(driver);
    }

    @BeforeEach
    public void setup() {
        driver.get("http://www.google.com");
    }

    @Test
    @DisplayName("Кейс 1. Проверка операций с целыми числами")
    public  void test1() {
        searchPage.search("Калькулятор (1 + 2) × 3 - 40 ÷ 5");
        assertAll(
                () -> assertEquals("((1 + 2) * 3) - (40 / 5) =", calcPage.getCalcInput()),
                () -> assertEquals("1", calcPage.getCalcOutput())
        );
    }



    /*@AfterAll
    public static void teardown() {
        driver.quit();
    }*/
}
