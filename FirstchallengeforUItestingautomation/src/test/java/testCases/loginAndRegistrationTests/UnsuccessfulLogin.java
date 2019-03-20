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

public class UnsuccessfulLogin {

    WebDriver driver;
    PropertiesReader propertiesReader = new PropertiesReader();
    URLData urlData = new URLData();


    @Test
    public void verifyUnsuccessfulRegistrationWrongUsername(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood(propertiesReader.getValueByKey("wrongUsername"),
                propertiesReader.getValueByKey("passwordUser"));
        loginPage.waitForWrongButton();
        Assert.assertEquals(driver.findElement(By.xpath(" //*[@id='exampleModalLongTitle']")).getText(),
                "¡HA OCURRIDO UN ERROR!");
        System.out.println("The assertion passed, " +
                "the username: " + propertiesReader.getValueByKey("wrongUsername") +
                " is not valid");
    }

    @Test
    public void verifyUnsuccessfulRegistrationWrongPassword(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood(propertiesReader.getValueByKey("user"),
                propertiesReader.getValueByKey("wrongPassword"));

        loginPage.waitForWrongButton();
        Assert.assertEquals(driver.findElement(By.xpath(" //*[@id='exampleModalLongTitle']")).getText(),
                "¡HA OCURRIDO UN ERROR!");
        System.out.println("The assertion passed, " +
                "the password is not valid");
    }

    @Test
    public void verifyUnsuccessfulRegistrationWrongPasswordAndUsername(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        loginPage.loginEcofood(propertiesReader.getValueByKey("wrongUsername"),
                propertiesReader.getValueByKey("wrongPassword"));

        loginPage.waitForWrongButton();
        Assert.assertEquals(driver.findElement(By.xpath(" //*[@id='exampleModalLongTitle']")).getText(),
                "¡HA OCURRIDO UN ERROR!");
        System.out.println("The assertion passed, " +
                "the username: " + propertiesReader.getValueByKey("wrongUsername") +
                " and the password are not valid");
    }

    @Test
    public void verifyUnsuccessfulRegistrationNullData(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.waitLoadInvisibilityOf(loginPage.getPageLoader());
        DataUser data = new DataUser();
        loginPage.loginEcofood(" ",
                " ");

        loginPage.waitForWrongButton();
        Assert.assertEquals(driver.findElement(By.xpath(" //*[@id='exampleModalLongTitle']")).getText(),
                "¡HA OCURRIDO UN ERROR!");
        System.out.println("The assertion passed, " +
                "the username and the password are null");
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
