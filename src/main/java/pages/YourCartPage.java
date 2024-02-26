package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage {
    @FindBy(xpath = "//div[contains(text(),'Your Cart')]")
    WebElement yourCartTitle;
    @FindBy(css = ".checkout_button")
    WebElement checkOutButton;


    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    public String verifyTile() {
        return yourCartTitle.getText();
    }

    public void clickCheckoutButton() {
        scrollToElement(checkOutButton);
        checkOutButton.click();
    }
}
