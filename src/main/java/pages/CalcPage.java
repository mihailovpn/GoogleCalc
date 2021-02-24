package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CalcPage {

    @FindBy(css = "div.ULSxyf h2.Uo8X3b")
    public static WebElement resultPage;

    public String getResultPage() {
        return resultPage.getText();
    }

    public CalcPage(WebDriver driver) {
        initElements(driver, this);
    }

}
