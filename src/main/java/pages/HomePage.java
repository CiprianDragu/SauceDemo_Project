package pages;

import data.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    // Prima data declaram un camp de tip Webdriver pentru al putea folosi la PageFactory


    // Pentru a putea declara expresia PageFactory avem nevoie de un constructor


    // Anotarea @FindBy nu functioneaza fara PageFactory
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
