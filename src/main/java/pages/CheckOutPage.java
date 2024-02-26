package pages;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {
    @FindBy(css = ".subheader")
    WebElement checkOutTile;
    @FindBy(css = "#first-name")
    WebElement firstName;
    @FindBy(css = "#last-name")
    WebElement lastName;
    @FindBy(css = "#postal-code")
    WebElement zipCode;
    @FindBy(css = "input[value='CONTINUE']")
    WebElement continueButton;


    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public String checkOutTilePage() {
        return checkOutTile.getText();
    }

    public void inputFirsName() {
        firstName.sendKeys(TestData.FIRST_NAME);
    }

    public void inputLastName() {
        lastName.sendKeys(TestData.LAST_NAME);
    }

    public void inputPostalCode() {
        zipCode.sendKeys(TestData.ZIPE_CODE);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
