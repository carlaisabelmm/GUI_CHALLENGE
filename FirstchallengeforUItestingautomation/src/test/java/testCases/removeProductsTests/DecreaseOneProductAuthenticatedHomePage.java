package testCases.removeProductsTests;

import helpers.PropertiesReader;
import utils.DataUser;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.HomeProductPage;
import pages.LoginPage;
import utils.URLData;

import java.io.File;
import java.io.IOException;

public class DecreaseOneProductAuthenticatedHomePage {

    WebDriver driver;
    URLData urlData = new URLData();
    PropertiesReader propertiesReader = new PropertiesReader();

    @Test
    public void verifyDecreaseOneProductAuthenticatedHomePage() throws IOException {
        HomeProductPage homeProductPage = PageFactory.initElements(driver, HomeProductPage.class);
        homeProductPage.oneProductHomePageEcofoodDecrease();

        File shot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(shot,new File("C:\\Users\\Carla\\Documents\\shotDecrease1.jpg"));

        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                homeProductPage.getDeccreaseNumber());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");

        Assert.assertEquals(driver.findElement(By.className("totals")).getText(),
                homeProductPage.getProductsAddedCounterOneProduct());
        System.out.println("Assertion passed, " +
                "the number of products added of the home page equals " +
                "to the number of producs whithin the shopping cart");


    }

    @Before
    public void before(){
        driver = HomePage.startBrowser(urlData.getURLEcofood());
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood(propertiesReader.getValueByKey("user"),
                propertiesReader.getValueByKey("passwordUser"));

    }

    @After
    public void after(){
        driver.quit();
    }
}
