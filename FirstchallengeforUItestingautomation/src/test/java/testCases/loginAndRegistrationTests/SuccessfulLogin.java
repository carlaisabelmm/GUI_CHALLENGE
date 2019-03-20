package testCases.loginAndRegistrationTests;

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
import pages.LoginPage;
import utils.URLData;

public class SuccessfulLogin {

    WebDriver driver;
    URLData urlData = new URLData();
    PropertiesReader propertiesReader = new PropertiesReader();

    @Test
    public void verifySuccessfulLogin(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood(propertiesReader.getValueByKey("user"),
                propertiesReader.getValueByKey("passwordUser"));

        Assert.assertEquals(driver.findElement(By.xpath("//a[@href = '/']")).getText(),
                "Bienvenido " + propertiesReader.getValueByKey("user"));
        System.out.println("Assertion passed, " +
                "the user: " + propertiesReader.getValueByKey("user") +
                " has been logged in succesfully");

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
