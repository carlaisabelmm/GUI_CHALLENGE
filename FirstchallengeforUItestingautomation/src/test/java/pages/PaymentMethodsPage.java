package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PaymentMethodsPage extends BasePage {

    WebDriver driver;

    public PaymentMethodsPage(WebDriver driver) {
        super(driver);
       }

    @FindBy (how = How.XPATH, using = "//a[@href = '/paymentMethods/']")
    WebElement paymentMethodsLink;

    @FindBy (how = How.ID, using = "list_payment_btn")
    WebElement addPaymentMethodButton;

    @FindBy (how = How.ID, using = "card_number")
    WebElement cardNumber;

    @FindBy (how = How.ID, using = "exp_date")
    WebElement carExpirationDate;

    @FindBy (how = How.ID, using = "code")
    WebElement cardCode;

    @FindBy (how = How.ID, using = "sub_new")
    WebElement  saveButton;

    @FindBy (how = How.XPATH, using = "//button[@class = 'btn btn-success']")
    WebElement thanksButton;

    @FindBy(how = How.NAME, using = "check")
    WebElement checkIconPaymentMethod;

    @FindBy(how = How.ID, using = "purchase")
    WebElement purchaseButton;


    public void paymentMethodEcofood(String cardNumberField, String expirationDateField,
                                     String cardCodeField){
        paymentMethodsLink.click();
        waitLoadInvisibilityOf(getPageLoader());
        addPaymentMethodButton.click();
        cardNumber.sendKeys(cardNumberField);
        carExpirationDate.sendKeys(expirationDateField);
        cardCode.sendKeys(cardCodeField);
        saveButton.click();
        waitLoadClickable(thanksButton);
        thanksButton.click();
    }

    public void paymentMehodRegisteredCard(){
        waitLoadInvisibilityOf(getPageLoader());
        checkIconPaymentMethod.click();
        purchaseButton.click();

    }
}
