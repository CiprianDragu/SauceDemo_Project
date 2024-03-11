package pages;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".login_logo")
    private WebElement pageLogo;
    @FindBy(css = "#user-name")
    WebElement userNameField;
    @FindBy(css = "#password")
    WebElement passwordField;
    @FindBy(css = "#login-button")
    WebElement loginButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLogoDisplayed() {
        return pageLogo.isDisplayed();
    }

    public void insertUserName() {
        userNameField.sendKeys(TestData.NAME);
    }

    public void insertPassword() {
        passwordField.sendKeys(TestData.PASSWORD);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


}
