package zadanie2;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import zadanie2.ChoiceShopPage;
import zadanie2.MyShopPage;
import zadanie2.LoginShopPage;
import zadanie2.BuyShopPage;
import java.awt.*;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestShopPage {
        private static WebDriver driver;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?");
    }

    @Test
    public void loginTest() {
        LoginShopPage loginShopPage = new LoginShopPage(this.driver);
        MyShopPage myShopPage = new MyShopPage(this.driver);
        ChoiceShopPage choiceShopPage = new ChoiceShopPage(this.driver);
        BuyShopPage buyShopPage = new BuyShopPage(this.driver);

        loginShopPage.loginAs("mythn1@hotmail.com", "Dupajasia1");
        Assert.assertEquals("Daniel Bukalski", loginShopPage.getLoggedUserName());
        System.out.println("Correct Login");


        loginShopPage.setButtonStore();

        myShopPage.setSearch("Sweater");
        myShopPage.setClickLoop();
        myShopPage.setPrintedSweater();


        choiceShopPage.setItemQuantity("5");
        choiceShopPage.setSize("M");
        choiceShopPage.setAddItemToBasket();
        choiceShopPage.setGoToCheckout();
        choiceShopPage.setCheckout();


        buyShopPage.setCheckAddress();
        buyShopPage.setButton();
        buyShopPage.setShippingMethod();
        buyShopPage.setClickPay();
        buyShopPage.setAcceptButton();
        buyShopPage.setPayCheck();


        File screenshotConfrimated = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotConfrimated, new File("/home/daniel/Obrazy/screenshot.png"));
        } catch (Exception e) {
            System.out.println("File has been saved incorrectly");
        }

    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
