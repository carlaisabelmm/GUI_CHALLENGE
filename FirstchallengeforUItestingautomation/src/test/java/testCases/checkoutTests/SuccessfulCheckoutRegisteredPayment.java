package testCases.checkoutTests;

import pages.BasePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class SuccessfulCheckoutRegisteredPayment {

    WebDriver driver;

    @Test
    public void verifySuccessfulCheckoutRegisteredPayment(){
        PaymentMethodsPage paymentMethodsPage = PageFactory.initElements(driver, PaymentMethodsPage.class);
        CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        paymentMethodsPage.paymentMethodEcofood("312345678924354",
                "02/19",
                "272");
        paymentMethodsPage.waitLoadInvisibilityOf(paymentMethodsPage.getPageLoader());
        checkoutPage.checkoutPageEcofood();
        paymentMethodsPage.paymentMehodRegisteredCard();
    }

    @Before
    public void before(){
        driver = HomePage.startBrowser("http://ecofoodmarket.herokuapp.com/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        HomeProductPage homeProductPage = PageFactory.initElements(driver, HomeProductPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood("cmarquez",
                "Ecofood1*");
        homeProductPage.productHomePageEcofoodPlus();

    }

    @After
    public void after(){

    }
}
