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

public class UnsuccessfulLogin {

    WebDriver driver;
    String alert;

    @Test
    public void verifyUnsuccessfulRegistrationWrongUsername(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        DataUser data = new DataUser();
        loginPage.loginEcofood(data.getWrongUsername(),
                data.getPassword());
        loginPage.waitForWrongButton();
        Assert.assertEquals(driver.findElement(By.xpath(" //*[@id='exampleModalLongTitle']")).getText(),"¡HA OCURRIDO UN ERROR!");
        System.out.println("The assertion passed, " +
                "the username: " + data.getWrongUsername() +
                " is not valid");
    }

    @Test
    public void verifyUnsuccessfulRegistrationWrongPassword(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        DataUser data = new DataUser();
        loginPage.loginEcofood(data.getUsername(),
                data.getWrongPassword());

        loginPage.waitForWrongButton();
        Assert.assertEquals(driver.findElement(By.xpath(" //*[@id='exampleModalLongTitle']")).getText(),"¡HA OCURRIDO UN ERROR!");
        System.out.println("The assertion passed, " +
                "the password is not valid");
    }

    @Test
    public void verifyUnsuccessfulRegistrationWrongPasswordAndUsername(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        DataUser data = new DataUser();
        loginPage.loginEcofood(data.getWrongUsername(),
                data.getWrongPassword());

        loginPage.waitForWrongButton();
        Assert.assertEquals(driver.findElement(By.xpath(" //*[@id='exampleModalLongTitle']")).getText(),
                "¡HA OCURRIDO UN ERROR!");
        System.out.println("The assertion passed, " +
                "the username: " + data.getWrongUsername() +
                " and the password are not valid");
    }

    @Test
    public void verifyUnsuccessfulRegistrationNullData(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        DataUser data = new DataUser();
        loginPage.loginEcofood(data.getNullUsername(),
                data.getNullPassword());

        loginPage.waitForWrongButton();
        Assert.assertEquals(driver.findElement(By.xpath(" //*[@id='exampleModalLongTitle']")).getText(),
                "¡HA OCURRIDO UN ERROR!");
        System.out.println("The assertion passed, " +
                "the username: " + data.getNullUsername() +
                " and the password are null");
    }

    @Before
    public void before(){
        driver = HomePage.startBrowser("http://ecofoodmarket.herokuapp.com/");
    }

    @After
    public void after(){

        driver.quit();
    }
}
