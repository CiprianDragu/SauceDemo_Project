package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends BasePage {
    @FindBy(xpath = "//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")
    WebElement thankYouMessageText;


    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public String ValidateOrder() {
        return thankYouMessageText.getText();
    }
}
