package testCases.checkoutTests;

import helpers.PropertiesReader;
import pages.BasePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import utils.URLData;

import java.io.IOException;

public class SuccessfulCheckoutRegisteredPayment {

    WebDriver driver;
    URLData urlData = new URLData();
    PropertiesReader propertiesReader = new PropertiesReader();

    @Test
    public void verifySuccessfulCheckoutRegisteredPayment() {
        PaymentMethodsPage paymentMethodsPage = PageFactory.initElements(driver, PaymentMethodsPage.class);
        CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        paymentMethodsPage.paymentMethodEcofood(propertiesReader.getValueByKey("cardNumber"),
                propertiesReader.getValueByKey("expirationDate"),
                propertiesReader.getValueByKey("codeCardNumber"));

        paymentMethodsPage.waitLoadInvisibilityOf(paymentMethodsPage.getPageLoader());
        checkoutPage.checkoutPageEcofood();
        paymentMethodsPage.paymentMehodRegisteredCard();
    }

    @Before
    public void before(){
        driver = HomePage.startBrowser(urlData.getURLEcofood());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomeProductPage homeProductPage = PageFactory.initElements(driver, HomeProductPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood(propertiesReader.getValueByKey("user"),
                propertiesReader.getValueByKey("passwordUser"));
        homeProductPage.productHomePageEcofoodPlus();

    }

    @After
    public void after(){
            driver.quit();
    }
}
