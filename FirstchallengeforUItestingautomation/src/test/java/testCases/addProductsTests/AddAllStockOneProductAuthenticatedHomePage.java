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

        Assert.assertNotNull(homePageProduct.getProductsAddedCounterOneProduct());
        System.out.println("Assertion passed, " +
                "there are not null elements on the list added");

        Assert.assertNotNull(driver.findElement(By.className("totals")).getText());
        System.out.println("Assertion passed, " +
                "there are not null elements on the shopping cart");

        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                homePageProduct.getProductsAddedCounterOneProduct());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");

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
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        loginPage.loginEcofood("cmarquez",
                "Ecofood1*");

}
    @After
    public void after(){

        driver.quit();
    }
}
