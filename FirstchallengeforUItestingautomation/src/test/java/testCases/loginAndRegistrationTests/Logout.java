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
import pages.LogoutPage;
import utils.URLData;

public class Logout {

    WebDriver driver;
    URLData urlData = new URLData();
    PropertiesReader propertiesReader = new PropertiesReader();


    @Test
    public void verifySuccessfullLogout(){
        LogoutPage logoutPage = PageFactory.initElements(driver,LogoutPage.class);
        logoutPage.waitLoadInvisibilityOf(logoutPage.getPageLoader());
        logoutPage.logoutEcoffod();

        Assert.assertEquals(driver.findElement(By.xpath("//a[@href = '/login/']")).getText(),
                "Iniciar sesión");
        System.out.println("Assertion passed, " +
                "the user: has been logged out");


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
