package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends BasePage{

    WebDriver driver;
    int count;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//i[@class = 'fa fa-shopping-cart']")
    WebElement shoppingCartIcon;

    @FindBy(how = How.XPATH, using = "//span[@class='totals']")
    WebElement shoppingCartNumberOfElementsAdded;

    @FindBy(how = How.XPATH, using = "//button[@class = 'au-btn au-btn-primary au-btn-radius btn-checkout']")
    WebElement checkoutButton;

    @FindBy(how = How.XPATH, using = "//*[@id='products_ids']/thead/tr")
    WebElement tuOrdenTableHead;

    @FindBy(how = How.XPATH, using = "//*[@id='products_ids']/tbody/tr/td")
    List<WebElement> productDetailTableBody;

    @FindBy(how = How.XPATH, using = "//input[@id = 'card_number']")
    WebElement cardNumber;

    @FindBy(how = How.ID, using =  "exp_date")
    WebElement cardExpirationDate;

    @FindBy(how = How.ID, using = "code")
    WebElement cardCode;

    @FindBy(how = How.ID, using = "purchase")
    WebElement purchaseButton;

    @FindBy(how = How.XPATH, using = "//*[@id='exampleModalLongTitle']")
    WebElement errorMessage;


    public void checkoutPageEcofood(){
        waitLoadClickable(shoppingCartIcon);
        shoppingCartIcon.click();
        System.out.println(shoppingCartNumberOfElementsAdded.getText());
        checkoutButton.click();
    }

    public void calculateProductsAddedToTheShoppingCart(){
        waitToBeVisible(tuOrdenTableHead);

        for(int i=0; i < productDetailTableBody.size(); i++){
           System.out.println(productDetailTableBody.get(i).getText());
            count++;
        }   System.out.println(count);
    }

    public void cardCreditData(String cardNumberField, String expirationDateField, String cardCodeField){
        waitLoadInvisibilityOf(getPageLoader());
        waitLoadClickable(cardNumber);
        cardNumber.click();
        cardNumber.sendKeys(cardNumberField);
        cardExpirationDate.sendKeys(expirationDateField);
        cardCode.sendKeys(cardCodeField);
        purchaseButton.click();
    }


    public void waitForWrongButton(){
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        basePage.waitToBeVisible(errorMessage);
    }

    public void getTextShoppingCartNumberOfElementsAdded(){
        shoppingCartNumberOfElementsAdded.getText();
    }
}