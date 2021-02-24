package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DetailsPage;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class googleCalc {
    private static WebDriver driver;
    private static SearchPage searchPage;
    private static DetailsPage detailsPage;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        searchPage = new SearchPage(driver);
        detailsPage = new DetailsPage(driver);
    }

    @BeforeEach
    public void setup() {
        driver.get("http://www.google.com");
    }

    @Test
    @DisplayName("Кейс 1. Про")
    public  void test1() {
        searchPage.search("Калькулятор");
        assertEquals(9, searchPage.results.size());
    }

    @Test
    @DisplayName("Проверка деталей ресурса")
    public void test2() {
        searchPage.search("selenium");
        assertAll(
                () -> assertEquals("Selenium", detailsPage.getName()),
                () -> assertEquals("3.141.59 (14 ноября 2018 года)", detailsPage.getLastVersion()),
                () -> assertEquals("Apache License 2.0", detailsPage.getLicense())
        );
    }



    @AfterAll
    public static void teardown() {
        driver.quit();
    }
}
