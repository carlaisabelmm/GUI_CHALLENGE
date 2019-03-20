package testCases.addProductsTests;

import helpers.DataUser;
import pages.BasePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CatalogProductPage;
import pages.HomePage;
import pages.LoginPage;

public class AddProductsAuthenticatedCatalog {

    WebDriver driver;

    @Test
    public void verifyAddProductAuthenticatedCatalog(){
        CatalogProductPage catalogProductPage = PageFactory.initElements(driver,CatalogProductPage.class);
        catalogProductPage.waitLoadInvisibilityOf(catalogProductPage.getPageLoader());
        catalogProductPage.productsCatalogEcofood();

        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                catalogProductPage.getProductsAddedCounter());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");

    }

    @Test
    public void verifyAddProductAuthenticatedFruitCatalog(){
        CatalogProductPage catalogProductPage = PageFactory.initElements(driver,CatalogProductPage.class);
        catalogProductPage.waitLoadInvisibilityOf(catalogProductPage.getPageLoader());
        catalogProductPage.productCatalogFruitEcofood();

        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                catalogProductPage.getProductsAddedCounter());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");

    }

    @Test
    public  void verifyAddProductAuthenticatedVegetableCatalog(){
        CatalogProductPage catalogProductPage = PageFactory.initElements(driver,CatalogProductPage.class);
        catalogProductPage.waitLoadInvisibilityOf(catalogProductPage.getPageLoader());
        catalogProductPage.productCatalogVegetableEcofood();

        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                catalogProductPage.getProductsAddedCounter());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");
    }

    @Before
    public void before(){
        DataUser data = new DataUser();
        driver = HomePage.startBrowser("http://ecofoodmarket.herokuapp.com/");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood(data.getUsername(),
                data.getPassword());
    }

    @After
    public void after()
    {
        driver.quit();
    }
}