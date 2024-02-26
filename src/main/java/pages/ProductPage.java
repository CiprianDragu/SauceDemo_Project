package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//div[contains(text(),'Products')]")
    WebElement productTitle;
    @FindBy(css = ".shopping_cart_badge")
    WebElement shoppingCart;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return productTitle.getText();
    }

    public void listOfElementsTest() {
        boolean itsClicked = false;
        List<WebElement> products = driver.findElements(By.xpath("//button[contains(text(),'ADD TO CART')]"));
        int size = products.size();
        System.out.println("Size of the list " + size);
        for (int i = 0; i < size; i++) {
            itsClicked = products.get(i).isSelected();

            if (!itsClicked) {
                products.get(i).click();

            }
        }
    }

    public void cartNumberItems() {
        shoppingCart.click();
    }
}
