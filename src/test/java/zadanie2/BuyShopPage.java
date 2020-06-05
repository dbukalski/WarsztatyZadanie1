package zadanie2;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuyShopPage {
 private WebDriver driver;

     public BuyShopPage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
     }

    @FindBy(xpath = "//article")
    private WebElement checkAddress;

    @FindBy(name = "confirm-addresses")
    private WebElement clickButton;

    @FindBy(id = "delivery_option_1")
    private WebElement Shop;

    @FindBy(xpath = "//*[@id='js-delivery']/button")
    private WebElement shippingMethod;

    @FindBy(id = "payment-option-1")
    private WebElement clickPay;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement acceptButton;

    @FindBy(xpath = "//*[@id='payment-confirmation']/div[1]/button")
    private WebElement obligationPay;

    public void setCheckAddress() {
    System.out.println(checkAddress.getText());
    String actualtext = checkAddress.getText();
    Assert.assertTrue(actualtext.contains("Gorka 10"));
    System.out.println("Address corected");

 }

    public void setButton() {
    try {
    Thread.sleep(2000);
  } catch (InterruptedException e) {
    e.printStackTrace();
  }
    clickButton.click();
 }

    public void setShippingMethod() {
    shippingMethod.click();
 }

    public void setClickPay() {
    clickPay.click();
 }

   public void setAcceptButton() {
   acceptButton.click();
 }

   public void setPayCheck() {
   obligationPay.click();
 }

}