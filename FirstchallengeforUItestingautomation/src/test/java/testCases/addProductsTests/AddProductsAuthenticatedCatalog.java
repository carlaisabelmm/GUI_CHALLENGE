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
        BasePage pageLoader = PageFactory.initElements(driver, BasePage.class);
        pageLoader.waitLoadInvisibilityOf(pageLoader.getPageLoader());
        catalogProductPage.productsCatalogEcofood();

        Assert.assertNotNull(catalogProductPage.getProductsAddedCounter());
        System.out.println("Assertion passed," +
                "there are not null elements on the list added");

        Assert.assertNotNull(driver.findElement(By.className("totals")).getText());
        System.out.println("Assertion passed, " +
                "there are not null elements on the shopping cart");

        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                catalogProductPage.getProductsAddedCounter());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");

    }

    @Test
    public void verifyAddProductAuthenticatedFruitCatalog(){
        CatalogProductPage catalogProductPage = PageFactory.initElements(driver,CatalogProductPage.class);
        BasePage pageLoader = PageFactory.initElements(driver, BasePage.class);
        pageLoader.waitLoadInvisibilityOf(pageLoader.getPageLoader());
        catalogProductPage.productCatalogFruitEcofood();

        Assert.assertNotNull(catalogProductPage.getProductsAddedCounter());
        System.out.println("Assertion passed, " +
                "there are not null elements on the list added");

        Assert.assertNotNull(driver.findElement(By.className("totals")).getText());
        System.out.println("Assertion passed, " +
                "there are not null elements on the shopping cart");

        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                catalogProductPage.getProductsAddedCounter());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");

    }

    @Test
    public  void verifyAddProductAuthenticatedVegetableCatalog(){
        CatalogProductPage catalogProductPage = PageFactory.initElements(driver,CatalogProductPage.class);
        BasePage pageLoader = PageFactory.initElements(driver, BasePage.class);
        pageLoader.waitLoadInvisibilityOf(pageLoader.getPageLoader());
        catalogProductPage.productCatalogVegetableEcofood();

        Assert.assertNotNull(catalogProductPage.getProductsAddedCounter());
        System.out.println("Assertion passed, " +
                "there are not null elements on the list added");

        Assert.assertNotNull(driver.findElement(By.className("totals")).getText());
        System.out.println("Assertion passed, " +
                "there are not null elements on the shopping cart");

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
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        loginPage.loginEcofood(data.getUsername(),
                data.getPassword());
    }

    @After
    public void after()
    {
        driver.quit();
    }
}