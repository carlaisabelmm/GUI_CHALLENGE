package testCases.loginAndRegistrationTests;

import helpers.DataUser;
import pages.BasePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.RegistrationPage;

public class SuccessfullRegistration {

    WebDriver driver;

    @Test
    public void verifySuccessRegistration(){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.waitLoadInvisibilityOf(registrationPage.getPageLoader());
        DataUser data = new DataUser();
        registrationPage.registrationEcofood(data.getName(),
                data.getLastname(),
                data.getUsername(),
                data.getEmail(),
                data.getPassword(),
                data.getPassword());

        BasePage.waitToAler(driver);
        String alert = driver.switchTo().alert().getText();
        Assert.assertEquals("Usuario creado", alert);
        System.out.println("Assertion passed, the user: " + data.getUsername() +
                " has been registered successfully");

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
