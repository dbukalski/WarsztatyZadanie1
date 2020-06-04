package zadanie1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(name="email")
    private WebElement emailInput;

    @FindBy(name="password")
    private WebElement passwordInput;

    @FindBy(id="submit-login")
    private WebElement subbmitButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void loginAs(String email, String password) {

        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("mythn1@hotmail.com");

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Dupajasia1");

        subbmitButton.click();

    }
}