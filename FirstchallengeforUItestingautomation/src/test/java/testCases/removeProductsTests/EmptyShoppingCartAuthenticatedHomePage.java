package testCases.removeProductsTests;

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

public class EmptyShoppingCartAuthenticatedHomePage {

    WebDriver driver;

    @Test
    public void verifyEmptyShoppingCartAuthenticatedHomePage(){
        HomeProductPage homeProductPage = PageFactory.initElements(driver,HomeProductPage.class);
        homeProductPage.productHomePageEcofoodPlus();
        homeProductPage.productHomePageEcofoodEmpty();

        Assert.assertNotNull(homeProductPage.getProductsAddedCounter());
        System.out.println("Assertion passed, " +
                "there are not null elements on the list added");

        Assert.assertNotNull(driver.findElement(By.className("totals")).getText());
        System.out.println("Assertion passed, " +
                "there are not null elements on the shopping cart");

        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                "0");
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");
    }


    @Before
    public void before(){
        DataUser dataUser = new DataUser();
        driver = HomePage.startBrowser("http://ecofoodmarket.herokuapp.com/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
          loginPage.loginEcofood(dataUser.getUsername(),
                dataUser.getPassword());
    }

    @After
    public void after(){
        driver.quit();
    }


}
