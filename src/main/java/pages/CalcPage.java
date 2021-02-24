package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CalcPage {

    @FindBy(css = "div.ULSxyf h2.Uo8X3b")
    public static WebElement calcPage;

    @FindBy(css = "span[jsname='ubtiRe']")
    public static WebElement calcInput;

    @FindBy(css = "span[jsname='VssY5c']")
    public static WebElement calcOutput;

    @FindBy(css = "div.PaQdxb")
    public List<WebElement> calcButtons;

    @FindBy(css = "div[jsname='aN1RFf']")
    public WebElement sinButton;

    @FindBy(css = "div[jsname='Pt8tGc']")
    public WebElement equalsButton;

    public String getCalcPage() {
        return calcPage.getText();
    }

    public String getCalcInput() {
        return calcInput.getText();
    }

    public String getCalcOutput() {
        return calcOutput.getText();
    }

    public void calcSin() {
        sinButton.click();
        equalsButton.click();
    }

/*
    public void calcExpr(String text) {
        calcInput.sendKeys(text, Keys.ENTER);
    }*/

    public CalcPage(WebDriver driver) {
        initElements(driver, this);
    }

}
