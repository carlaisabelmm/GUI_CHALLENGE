package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//a[@href ='/regUser/']")
    WebElement registerLink;

    @FindBy(how = How.ID, using = "name")
    WebElement name;

    @FindBy(how = How.ID, using = "lastname")
    WebElement lastname;

    @FindBy(how = How.ID, using = "username")
    WebElement username;

    @FindBy(how = How.ID, using = "email")
    WebElement email;

    @FindBy(how = How.ID, using = "pass1")
    WebElement pass1;

    @FindBy(how = How.ID, using = "pass2")
    WebElement pass2;

    @FindBy(how = How.ID, using = "register")
    WebElement registrationButton;

    public void registrationEcofood(String nameRegister, String lastnameRegister, String usernameRegiter,
                                    String emailRegiter, String pass1Register, String pass2Register){
        registerLink.click();
        name.sendKeys(nameRegister);
        lastname.sendKeys(lastnameRegister);
        username.sendKeys(usernameRegiter);
        email.sendKeys(emailRegiter);
        pass1.sendKeys(pass1Register);
        pass2.sendKeys(pass2Register);
        BasePage loadRegisterButton = PageFactory.initElements(driver, BasePage.class);
        loadRegisterButton.waitLoadClickable(registrationButton);
        registrationButton.click();

    }


}