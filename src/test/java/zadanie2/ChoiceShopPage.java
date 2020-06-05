package zadanie2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChoiceShopPage {
    private WebDriver driver;

    public ChoiceShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "group_1")
    private WebElement ItemSize;

    @FindBy(id = "quantity_wanted")
    private WebElement ItemQuantity;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addItemToBasket;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement checkoutButton2;

    public void setSize(String size) {
        ItemSize.click();
        ItemSize.sendKeys(size);
    }

    public void setItemQuantity(String quantity) {
        ItemQuantity.clear();
        ItemQuantity.sendKeys(quantity);

    }

    public void setAddItemToBasket() {
        addItemToBasket.click();
    }

    public void setGoToCheckout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutButton.click();
    }

    public void setCheckout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkoutButton2.click();
    }
}