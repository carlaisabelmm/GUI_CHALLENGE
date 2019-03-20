package pages;

import helpers.RandomHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import java.util.List;
import java.util.Random;

public class HomeProductPage {

    WebDriver driver;
    Random random =new Random();
    RandomHelper randomLimits = new RandomHelper();
    String productNameDetail;
    int count;
    int count1 = 0;
    int maxNumberOfProduct = 0;
    int decrease = 0;

    public HomeProductPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//div[@class='miso-prd-qty']")
    List<WebElement> productImageHomePage;

    @FindBy(how = How.XPATH, using = "//a[@class='fa fa-plus']")
    List<WebElement> productPlusButtonHomePage;

    @FindBy(how = How.XPATH, using = "//a[@class = 'fa fa-minus']")
    List<WebElement> productDecreaseButtonHomePage;

    @FindBy(how = How.XPATH, using = "//a[@class = 'fa fa-remove']")
    List<WebElement> productEmptyButtonHomePage;

    @FindBy(how = How.XPATH, using = "//a [@class = 'fa fa-search-plus']")
    List<WebElement> productDetailButtonHomePage;

    @FindBy(how = How.XPATH, using = "//div [@class = 'miso-prd-total']")
    List<WebElement> listOfAvaliableProducts;

    @FindBy(how = How.XPATH, using = "//h3 [@class = 'title']")
    List<WebElement> productName;

    public void productHomePageEcofoodPlus() {
        BasePage loadHomePage = PageFactory.initElements(driver, BasePage.class);
        loadHomePage.waitLoadInvisibilityOf(loadHomePage.getPageLoader());
        int addProductsSize = randomLimits.randomIntLimits(1,productImageHomePage.size());
        for (int i=0; i <= addProductsSize; i++) {
            productImageHomePage.get(i).click();
           for (int j=0; j < random.nextInt(9); j++) {
                productPlusButtonHomePage.get(i).click();
                count++;
            }
        }
    }

    public void oneProductHomePageEcofoodPlus() {
        BasePage loadHomePage = PageFactory.initElements(driver, BasePage.class);
        loadHomePage.waitLoadInvisibilityOf(loadHomePage.getPageLoader());
        int positionRandom = randomLimits.randomIntLimits(1,productImageHomePage.size());

        for(int j=0; j < productImageHomePage.size(); j++) {
            productImageHomePage.get(positionRandom).click();
            }
        maxNumberOfProduct = Integer.parseInt(listOfAvaliableProducts.get(positionRandom).getText());

         for (int i=0; i < maxNumberOfProduct; i++) {
            productImageHomePage.get(positionRandom).click();
            productPlusButtonHomePage.get(positionRandom).click();
            count1++;
            }
     }


    public void productHomePageEcofoodEmpty() {
         for (int i=0; i < productImageHomePage.size(); i++) {
            productImageHomePage.get(i).click();
            productEmptyButtonHomePage.get(i).click();
        }
    }


    public void oneProductHomePageEcofoodDecrease() {
        BasePage loadHomePage = PageFactory.initElements(driver, BasePage.class);
        loadHomePage.waitLoadInvisibilityOf(loadHomePage.getPageLoader());
        int positionRandom = randomLimits.randomIntLimits(1,productImageHomePage.size());

        for(int j=0; j < productImageHomePage.size(); j++) {
            productImageHomePage.get(positionRandom).click();
        }
        maxNumberOfProduct = randomLimits.randomIntLimits(1,Integer.parseInt(listOfAvaliableProducts.get(positionRandom).getText()));

        for (int i=0; i < maxNumberOfProduct; i++) {
            productImageHomePage.get(positionRandom).click();
            productPlusButtonHomePage.get(positionRandom).click();
            count++;
        }

        for (int i=0; i <= 1; i++) {
            productImageHomePage.get(positionRandom).click();
            productDecreaseButtonHomePage.get(positionRandom).click();
            decrease = maxNumberOfProduct--;
        }

        for (int i=0; i <= maxNumberOfProduct; i++) {
            productImageHomePage.get(positionRandom).click();
            productDecreaseButtonHomePage.get(positionRandom).click();
            count1 = count--;
        }

    }

    public void oneProductHomePageEcofoodDetail() {
        BasePage loadHomePage = PageFactory.initElements(driver, BasePage.class);
        loadHomePage.waitLoadInvisibilityOf(loadHomePage.getPageLoader());
        int positionRandom = randomLimits.randomIntLimits(1,productImageHomePage.size());

        for(int j=0; j < productImageHomePage.size(); j++) {
            productImageHomePage.get(positionRandom).click();
        }
        maxNumberOfProduct = randomLimits.randomIntLimits(1,Integer.parseInt(listOfAvaliableProducts.get(positionRandom).getText()));

        for (int i=0; i < maxNumberOfProduct; i++) {
            productImageHomePage.get(positionRandom).click();
            productPlusButtonHomePage.get(positionRandom).click();
            count++;
        }
            productNameDetail = productName.get(positionRandom).getText();
            productDetailButtonHomePage.get(positionRandom).click();

    }

    public String getProductDetail(){
        return productNameDetail;
    }


    public String getProductsAddedCounter(){
        String counter = Integer.toString(count);
        return counter;
    }

    public String getProductsAddedCounterUnauthenticated(){
        String counter = Integer.toString(count - 1);
        return counter;
    }

    public String getProductsAddedCounterOneProduct(){
        String counter = Integer.toString(count1);
        return counter;
    }

    public String getPositionRandom() {
        String counter = Integer.toString(maxNumberOfProduct);
        return counter;
    }

    public String getDeccreaseNumber(){
        String counter = Integer.toString(decrease);
        return  counter;
    }
}

