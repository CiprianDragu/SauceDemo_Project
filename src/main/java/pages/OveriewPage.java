package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OveriewPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'FINISH')]")
    WebElement finishButton;


    public OveriewPage(WebDriver driver) {
        super(driver);
    }

    public void submitOrderButton() {
        scrollToElement(finishButton);
        finishButton.click();
    }
}
