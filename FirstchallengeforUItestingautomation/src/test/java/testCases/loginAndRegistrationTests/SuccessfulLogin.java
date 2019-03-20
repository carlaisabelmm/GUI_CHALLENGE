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

public class SuccessfulLogin {

    WebDriver driver;

    @Test
    public void verifySuccessfulLogin(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        DataUser data =  new DataUser();
        loginPage.loginEcofood(data.getUsername(),
                data.getPassword());

        Assert.assertEquals(driver.findElement(By.xpath("//a[@href = '/']")).getText(),
                "Bienvenido " + data.getUsername());
        System.out.println("Assertion passed, " +
                "the user: " + data.getUsername() +
                " has been logged in succesfully");

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
