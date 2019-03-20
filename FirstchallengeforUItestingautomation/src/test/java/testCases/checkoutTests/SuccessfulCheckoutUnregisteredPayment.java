package testCases.checkoutTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import pages.BasePage;
import helpers.CreditCardData;
import helpers.DataUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
    public void verifySuccessfullCheckoutUniregiteredPayment() throws IOException {
        CreditCardData creditCardData = new CreditCardData();
        CheckoutPage checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
        checkoutPage.checkoutPageEcofood();
//
////        File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
////        FileUtils.copyFile(shot,new File("C:\\Users\\Carla\\Documents\\shotCeckoutUnregistered1.jpg"));

   //     checkoutPage.waitForWrongButton();
        checkoutPage.cardCreditData(creditCardData.getCardNumber(),
                creditCardData.getExpirationDate(),
                creditCardData.getExpirationDate());

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"exampleModalLong\"]/div/div/div[2]/text()")).getText(),"Orden realizada correctamente");
        System.out.println("The assertion passed, the checkout has been successfully added");

////div[@class='modal-body']
    }

    @Before
    public void before(){
        DataUser dataUser = new DataUser();
        driver = HomePage.startBrowser("http://ecofoodmarket.herokuapp.com/");
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginEcofood(dataUser.getUsername(),
                dataUser.getPassword());
        HomeProductPage homeProductPage = PageFactory.initElements(driver, HomeProductPage.class);
        homeProductPage.productHomePageEcofoodPlus();



    }

    @After
    public void after(){
        //driver.quit();

    }
}
