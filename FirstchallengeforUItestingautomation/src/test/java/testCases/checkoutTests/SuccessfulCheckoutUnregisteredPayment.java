package testCases.checkoutTests;

import helpers.PropertiesReader;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CheckoutPage;
import pages.HomePage;
import pages.HomeProductPage;
import pages.LoginPage;
import utils.URLData;

import java.io.IOException;

public class SuccessfulCheckoutUnregisteredPayment {

    WebDriver driver;
    URLData urlData = new URLData();
    PropertiesReader propertiesReader = new PropertiesReader();


    @Test
    public void verifySuccessfullCheckoutUniregiteredPayment() throws IOException {
        CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        checkoutPage.checkoutPageEcofood();

        checkoutPage.cardCreditData(propertiesReader.getValueByKey("cardNumber"),
                propertiesReader.getValueByKey("expirationDate"),
                propertiesReader.getValueByKey("codeCardNumber"));

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"exampleModalLong\"]/div/div/div[2]/text()")).getText(),"Orden realizada correctamente");
        System.out.println("The assertion passed, the checkout has been successfully added");
    }

    @Before
    public void before(){
        driver = HomePage.startBrowser(urlData.getURLEcofood());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood(propertiesReader.getValueByKey("user"),
                propertiesReader.getValueByKey("passwordUser"));
        HomeProductPage homeProductPage = PageFactory.initElements(driver, HomeProductPage.class);
        homeProductPage.productHomePageEcofoodPlus();
    }

    @After
    public void after(){
        driver.quit();

    }
}
