package testCases.checkoutTests;

import helpers.CreditCardData;
import helpers.DataUser;
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

import java.io.IOException;

public class SuccessfulCheckoutUnregisteredPayment {

    WebDriver driver;

    @Test
    public void verifySuccessfullCheckoutUniregiteredPayment(){

        CreditCardData creditCardData = new CreditCardData();
        CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        checkoutPage.checkoutPageEcofood();

        checkoutPage.cardCreditData(creditCardData.getCardNumber(),
                creditCardData.getExpirationDate(),
                creditCardData.getCode());

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"exampleModalLong\"]/div/div/div[2]/text()")).getText(),"Orden realizada correctamente");
        System.out.println("The assertion passed, the checkout has been successfully added");


    }

    @Before
    public void before(){
        DataUser dataUser = new DataUser();
        driver = HomePage.startBrowser("http://ecofoodmarket.herokuapp.com/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood(dataUser.getUsername(),
                dataUser.getPassword());
        HomeProductPage homeProductPage = PageFactory.initElements(driver, HomeProductPage.class);
        homeProductPage.productHomePageEcofoodPlus();



    }

    @After
    public void after(){
        driver.quit();

    }
}
