package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
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
        waitLoadInvisibilityOf(getPageLoader());
        waitLoadClickable(loginButton);
        loginButton.click();
    }

    public void waitForWrongButton(){
        waitToBeVisible(errorMessage);
    }



}