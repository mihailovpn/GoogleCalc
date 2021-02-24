package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CalcPage {

    @FindBy(css = "div.ULSxyf h2.Uo8X3b")
    public static WebElement calcPage;

    @FindBy(css = "span[jsname='ubtiRe']")
    public static WebElement calcInput;

    @FindBy(css = "span[jsname='VssY5c']")
    public static WebElement calcOutput;

    public String getCalcPage() {
        return calcPage.getText();
    }

    public String getCalcInput() {
        return calcInput.getText();
    }

    public String getCalcOutput() {
        return calcOutput.getText();
    }

/*
    public void calcExpr(String text) {
        calcInput.sendKeys(text, Keys.ENTER);
    }*/

    public CalcPage(WebDriver driver) {
        initElements(driver, this);
    }

}
