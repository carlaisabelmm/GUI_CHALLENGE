package testCases.addProductsTests;

import helpers.PropertiesReader;
import utils.DataUser;
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
import utils.URLData;

public class AddProductsUnauthenticated {

    WebDriver driver;
    PropertiesReader propertiesReader = new PropertiesReader();
    URLData urlData = new URLData();

    @Test
    public void verifyAddProductsUnauthenticated(){
        HomeProductPage homePageProduct = PageFactory.initElements(driver, HomeProductPage.class);
        homePageProduct.productHomePageEcofoodPlus();
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
          loginPage.loginEcofood(propertiesReader.getValueByKey("user"),
                propertiesReader.getValueByKey("passwordUser"));


        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                homePageProduct.getProductsAddedCounterUnauthenticated());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");

    }


    @Before
    public void before(){

        driver = HomePage.startBrowser(urlData.getURLEcofood());

    }

    @After
    public void after(){
        driver.quit();
    }
}
