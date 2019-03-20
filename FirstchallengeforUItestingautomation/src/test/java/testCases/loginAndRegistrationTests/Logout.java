package testCases.loginAndRegistrationTests;

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
import pages.LoginPage;
import pages.LogoutPage;

public class Logout {

    WebDriver driver;


    @Test
    public void verifySuccessfullLogout(){
        LogoutPage logoutPage = PageFactory.initElements(driver,LogoutPage.class);
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        logoutPage.logoutEcoffod();

        Assert.assertEquals(driver.findElement(By.xpath("//a[@href = '/login/']")).getText(),
                "Iniciar sesión");
        System.out.println("Assertion passed, " +
                "the user: has been logged out");


    }

    @Before
    public void before(){
        driver = HomePage.startBrowser("http://ecofoodmarket.herokuapp.com/");
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        DataUser dataUser = new DataUser();
        loginPage.loginEcofood(dataUser.getUsername(),
                dataUser.getPassword());

    }

    @After
    public void after(){

        driver.quit();
    }
}
