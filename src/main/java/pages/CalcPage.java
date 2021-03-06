package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CalcPage {

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

    public String getCalcInput() {
        return calcInput.getText();
    }

    public String getCalcOutput() {
        return calcOutput.getText();
    }

    public void enterExpression(String expression) {
        char[] chars = expression.toCharArray();
        for (char aChar : chars) {
            enterButton(String.valueOf(aChar));
        }
        equalsButton.click();
    }

    public void enterButton(String buttonName) {
        calcButtons.forEach(button -> {
             if (button.getText().equals(buttonName)) {
                 button.click();
             }
        });
    }

    public void calcSin() {
        sinButton.click();
        equalsButton.click();
    }

    public CalcPage(WebDriver driver) {
        initElements(driver, this);
    }

}
