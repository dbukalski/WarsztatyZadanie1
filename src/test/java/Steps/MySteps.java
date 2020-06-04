package Steps;

import Pages.MyPageAddress;
import Pages.PageObject;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import zadanie1.LoginPage;
import java.util.concurrent.TimeUnit;

public class MySteps {
    private WebDriver driver;

    private LoginPage loginPage;
    private PageObject pageObject;
    private MyPageAddress myPageAddress;
    private String alias;
    private String city;
    private String postCode;
    private String country;
    private String phone;
    private String address;


    @Given("^User logging$")
    public void userLogged() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
        loginPage = new LoginPage(driver);
        loginPage.loginAs("mythn1@hotmail.com", "Dupajasia1");

    }

    @When("^User going to page add new address$")
    public void userGoingToAddAddress() {
        MyPageAddress myPageAddress = new MyPageAddress(driver);
        myPageAddress.clickCreateAddressButton();

    }

    @And("^Guest added (.*), (.*), (.*), (.*), (.*), (.*) on address page$")
    public void guestaddedAliasAddressCityPostCodeCountryPhoneOnAddressPage(String alias, String address, String city, String postCode, String country, String phone) {
        PageObject pageObject = new PageObject(driver);

        pageObject.setAliasInput(alias);
        this.alias = alias;

        pageObject.setAddress(address);
        this.address = address;

        pageObject.setPostCodeInput(postCode);
        this.postCode = postCode;

        pageObject.setCityInput(city);
        this.city = city;

        pageObject.roleDropCountry(country);
        this.country = country;

        pageObject.setPhoneInput(phone);
        this.phone = phone;

        pageObject.checkTiles();
        String acctualText = pageObject.getCheckTiles();
        Assert.assertTrue(acctualText.contains("Daniel Bukalski"));
        Assert.assertTrue(acctualText.contains(this.alias));

        pageObject.setUpdateButton();

    }

    @Then("^Guest checking address correctnes$")
    public void userCheckingAddressCorrectnes() {
        PageObject pageObject = new PageObject(driver);

        Assert.assertEquals(this.alias, pageObject.getAlias());
        System.out.println("Alias name correct");
        Assert.assertEquals(this.address, pageObject.getAddress());
        System.out.println("Address name correct");
        Assert.assertEquals(this.postCode, pageObject.getPostCode());
        System.out.println("Post Code correct");
        Assert.assertEquals(this.city, pageObject.getCity());
        System.out.println("City name correct");
        Assert.assertEquals(this.country, pageObject.getCountry());
        System.out.println("Country name correct");
        Assert.assertEquals(this.phone, pageObject.getPhone());

    }
}
