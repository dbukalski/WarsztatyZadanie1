package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageObject {
    private WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="alias")
    private WebElement aliasInput;

    @FindBy(name="address1")
    private WebElement addressInput;

    @FindBy(name="city")
    private WebElement cityInput;

    @FindBy(name="postcode")
    private WebElement postCodeInput;

    @FindBy(name="id_country")
    private WebElement roleDropCountry;

    @FindBy(name="phone")
    private WebElement phoneInput;

    @FindBy(xpath="//article")
    private List<WebElement> blockList;

    @FindBy(xpath="/html/body/main/section/div/div/section/section/div[1]/article/div[2]/a[1]")
    private WebElement updateButton;


    public void setAliasInput(String alias) {
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }
    public void setAddress(String address) {
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);
    }
    public void setCityInput(String city) {
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }
    public void setPostCodeInput(String postCode) {
        postCodeInput.click();
        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);
    }

    public void roleDropCountry(String country) {
        Select drop = new Select(roleDropCountry);
        drop.selectByVisibleText(country);
    }
    public void setPhoneInput(String phone) {
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
        phoneInput.submit();
    }

    public void setUpdateButton() {
        updateButton.click();
    }
    public void checkTiles() {
      WebElement tilesCheck = blockList.get(blockList.size() - 1);
      System.out.println(tilesCheck.getText());
    }
    public String getCheckTiles() {
      WebElement tiles = blockList.get(blockList.size() - 1);
       return tiles.getText();
    }
    public String getAlias() {
        return aliasInput.getAttribute("value");
    }
    public String getAddress() {
        return addressInput.getAttribute("value");
    }
    public String getCity() {
        return cityInput.getAttribute("value");
    }
    public String getPostCode() {
        return postCodeInput.getAttribute("value");
    }
    public String getCountry() {
        Select drop = new Select(roleDropCountry);
        return drop.getFirstSelectedOption().getText();
    }
    public String getPhone() {
        return phoneInput.getAttribute("value");
    }
}





