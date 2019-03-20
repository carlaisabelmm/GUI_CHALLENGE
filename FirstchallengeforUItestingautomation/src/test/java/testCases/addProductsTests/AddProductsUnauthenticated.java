package testCases.addProductsTests;

import helpers.DataUser;
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

public class AddProductsUnauthenticated {

    WebDriver driver;

    @Test
    public void verifyAddProductsUnauthenticated(){
        DataUser dataUser = new DataUser();
        HomeProductPage homePageProduct = PageFactory.initElements(driver, HomeProductPage.class);
        homePageProduct.productHomePageEcofoodPlus();
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.loginEcofood(dataUser.getUsername(),
                dataUser.getPassword());

        Assert.assertNotNull(homePageProduct.getProductsAddedCounterUnauthenticated());
        System.out.println("Assertion passed, " +
                "there are not null elements on the list added");

        Assert.assertNotNull(driver.findElement(By.className("totals")).getText());
        System.out.println("Assertion passed, " +
                "there are not null elements on the shopping cart");

        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                homePageProduct.getProductsAddedCounterUnauthenticated());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");

    }


    @Before
    public void before(){

        driver = HomePage.startBrowser("http://ecofoodmarket.herokuapp.com/");

    }

    @After
    public void after(){
        driver.quit();
    }
}
