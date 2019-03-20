package testCases.addProductsTests;

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

public class AddAllStockOneProductAuthenticatedHomePage {

    WebDriver driver;

    @Test
    public void verifyAddAllStockOneProductAuthenticated() {
        HomeProductPage homePageProduct = PageFactory.initElements(driver, HomeProductPage.class);
        homePageProduct.oneProductHomePageEcofoodPlus();

        Assert.assertEquals(homePageProduct.getPositionRandom(),
                homePageProduct.getProductsAddedCounterOneProduct());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");

    }

    @Before
    public void before() {
        driver = HomePage.startBrowser("http://ecofoodmarket.herokuapp.com/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood("cmarquez",
                "Ecofood1*");

}
    @After
    public void after(){

        driver.quit();
    }
}
