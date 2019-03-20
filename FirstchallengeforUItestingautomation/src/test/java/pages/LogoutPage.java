package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogoutPage extends  BasePage{

    WebDriver driver;

    public LogoutPage(WebDriver driver) {
        super(driver);
        }

    @FindBy(how = How.XPATH, using = "//a[@href = '/logout/']")
    WebElement logoutLink;

    public void logoutEcoffod(){
        logoutLink.click();
    }
}
