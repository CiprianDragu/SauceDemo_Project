import data.TestData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.*;

public class BaseTest {
    @Test
    public void goToWebsiteTest() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(TestData.URL);
    }

    @Test
    public void verifyPageLogoTest() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(TestData.URL);
        HomePage homePage = new HomePage(driver);
        Assertions.assertTrue(homePage.isPageLogoDisplayed());
    }

    @Test
    public void loginTest() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(TestData.URL);
        HomePage homePage = new HomePage(driver);
        homePage.insertUserName();
        homePage.insertPassword();
        homePage.clickLoginButton();
        homePage.waitInSeconds(4);
        driver.quit();
    }


    @Test
    public void endToEndTest() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(TestData.URL);
        HomePage homePage = new HomePage(driver);
        homePage.insertUserName();
        homePage.insertPassword();
        homePage.clickLoginButton();
        ProductPage productPage = new ProductPage(driver);
        String actualTitle = productPage.getTitleText();
        String expectedTitle = "Products";
        Assertions.assertEquals(expectedTitle, actualTitle);
        productPage.listOfElementsTest();
        productPage.cartNumberItems();
        String actualColor = driver.findElement(By.cssSelector(".shopping_cart_badge")).getCssValue("background-color");
        String expectedColor = "rgba(255, 37, 58, 1)";
        Assertions.assertEquals(expectedColor, actualColor);
        YourCartPage yourCartPage = new YourCartPage(driver);
        yourCartPage.verifyTile();
        String actualTitlePage = yourCartPage.verifyTile();
        String expectedTitlePage = "Your Cart";
        Assertions.assertEquals(expectedTitlePage, actualTitlePage);
        yourCartPage.clickCheckoutButton();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.checkOutTitlePage();
        String actualPageTitle = checkOutPage.checkOutTitlePage();
        String expectedPageTitle = "Checkout: Your Information";
        Assertions.assertEquals(expectedPageTitle, actualPageTitle);
        checkOutPage.inputFirsName();
        checkOutPage.inputLastName();
        checkOutPage.inputPostalCode();
        checkOutPage.clickContinueButton();
        OveriewPage overiewPage = new OveriewPage(driver);
        overiewPage.submitOrderButton();
        FinishPage finishPage = new FinishPage(driver);
        finishPage.ValidateOrder();
        String actualTextMessage = finishPage.ValidateOrder();
        String expectedTextMessage = "THANK YOU FOR YOUR ORDER";
        Assertions.assertEquals(expectedTextMessage, actualTextMessage);
        finishPage.waitInSeconds(3);
        driver.quit();
    }
}

