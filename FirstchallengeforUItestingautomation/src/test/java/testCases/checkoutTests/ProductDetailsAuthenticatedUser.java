package testCases.checkoutTests;

import helpers.DataUser;
import pages.BasePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.HomeProductPage;
import pages.LoginPage;

public class ProductDetailsAuthenticatedUser {

    WebDriver driver;

    @Test
    public void verifyProductDetailsAuthenticatedUser(){
        HomeProductPage homeProductPage = PageFactory.initElements(driver, HomeProductPage.class);
        homeProductPage.oneProductHomePageEcofoodDetail();

        if(homeProductPage.getProductDetail() == "Canasta Premium"){
            Assert.assertEquals(driver.findElement(By.className("heading-widget")).getText(),
                    homeProductPage.getProductDetail());
            System.out.println("Assertion passed, " +
                    "the number of products added of the home page equals " +
                    "to the number of producs whithin the shopping cart");
        }else {
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id='product-detail-name']/h3")).getText(),
                    homeProductPage.getProductDetail());
            System.out.println("Assertion passed, " +
                    "the number of products added of the home page equals " +
                    "to the number of producs whithin the shopping cart");
        }
    }

    @Before
    public void before(){
        DataUser dataUser = new DataUser();
        driver = HomePage.startBrowser("http://ecofoodmarket.herokuapp.com/");
        BasePage basePage = PageFactory.initElements(driver,  BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.loginEcofood(dataUser.getUsername(),
                dataUser.getPassword());
    }

    @After
    public void after(){
        driver.quit();
    }
}
