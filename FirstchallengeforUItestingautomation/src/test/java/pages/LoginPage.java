package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//a[@href = '/login/']")
    WebElement loginLink;

    @FindBy(how = How.ID, using = "username")
    WebElement username;

    @FindBy(how = How.ID, using = "password")
    WebElement password;

    @FindBy(how = How.ID, using = "login")
    WebElement loginButton;

    @FindBy(how = How.XPATH, using = " //*[@id='exampleModalLongTitle']")
    WebElement errorMessage;


    public void loginEcofood(String usernameLogin, String passwordLogin){
        loginLink.click();
        username.sendKeys(usernameLogin);
        password.sendKeys(passwordLogin);
        BasePage basePage = PageFactory.initElements(driver,BasePage.class);
        basePage.waitLoadInvisibilityOf(basePage.getPageLoader());
        BasePage loadLoginButton = PageFactory.initElements(driver, BasePage.class);
        loadLoginButton.waitLoadClickable(loginButton);
        loginButton.click();
    }

    public void waitForWrongButton(){
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitToBeVisible(errorMessage);
    }



}