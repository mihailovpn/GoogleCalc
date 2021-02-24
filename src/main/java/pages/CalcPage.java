package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CalcPage {

    @FindBy(css = "#wp-tabs-container div[data-attrid*='poslednyaya_versiya'] .Eq0J8.LrzXr.kno-fv")
    private WebElement lastVersion;

    @FindBy(css = "#wp-tabs-container div[data-attrid*='licenziya'] .Eq0J8.LrzXr.kno-fv")
    private WebElement license;

    @FindBy(css = "#wp-tabs-container h2[data-attrid*='title']")
    private WebElement name;

    @FindBy(css = "div.ULSxyf h2.Uo8X3b")
    public WebElement resultPage;

    public CalcPage(WebDriver driver) {
        initElements(driver, this);
    }

    public String getLastVersion() {
        return lastVersion.getText();
    }

    public String getLicense() {
        return license.getText();
    }

    public String getName() {
        return name.getText();
    }
}
