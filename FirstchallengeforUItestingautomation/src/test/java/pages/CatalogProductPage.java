package pages;

import utils.RandomHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Random;

public class CatalogProductPage extends  BasePage{

    WebDriver driver;
    Random random =new Random();
    RandomHelper randomLimits = new RandomHelper();
    int count;

    public CatalogProductPage(WebDriver driver) {
        super(driver);
        }

    @FindBy(how = How.XPATH, using = "//a[@href = '/catalogo/']")
    WebElement catalogLink;

    @FindBy(how = How.XPATH, using = "//a [@href = '#'] ")
    List<WebElement> productsCategory;

    @FindBy(how = How.ID, using = "category0")
    WebElement fruitCategoryLink;

    @FindBy(how = How.ID, using = "category1")
    WebElement vegetableCategoryLink;

    @FindBy(how = How.XPATH, using = "//div[@class='miso-prd-qty']")
    List<WebElement> productImageCatalog;

    @FindBy(how = How.XPATH, using = "//a[@class='fa fa-plus']")
    List<WebElement> productPlusButtonCatalog;

    public void productsCatalogEcofood(){
        catalogLink.click();
        waitLoadInvisibilityOf(getPageLoader());
        int catalogSize = randomLimits.randomIntLimits(1,2);

        System.out.println(catalogSize);

        productsCategory.get(catalogSize).click();

        int addProductsSize = randomLimits.randomIntLimits(1,productImageCatalog.size());

        if (catalogSize == 1) {
           for (int i=0; i < addProductsSize; i++){
                productImageCatalog.get(i).click();
                for(int j=0; j < random.nextInt(9); j++){
                    productPlusButtonCatalog.get(i).click();
                    count ++;
                }

            }

        }else if (catalogSize == 2) {
            for (int i=0; i < addProductsSize; i++) {
                productImageCatalog.get(i).click();
                for(int j=0; j < random.nextInt(9); j++ ){
                    productPlusButtonCatalog.get(i).click();
                    count ++;
                }
            }System.out.println(count);
        }

    }

    public void productCatalogFruitEcofood(){
        catalogLink.click();
        waitLoadInvisibilityOf(getPageLoader());
        fruitCategoryLink.click();
        int addProductsSize = randomLimits.randomIntLimits(1,productImageCatalog.size());
        for(int i=0; i < addProductsSize; i++) {
            productImageCatalog.get(i).click();
            for (int j = 0; j < random.nextInt(9); j++) {
                productPlusButtonCatalog.get(i).click();
                count ++;
            }
        }
    }

    public void productCatalogVegetableEcofood(){
        catalogLink.click();
        waitLoadInvisibilityOf(getPageLoader());
        vegetableCategoryLink.click();
        int addProductsSize = randomLimits.randomIntLimits(1,productImageCatalog.size());
        for(int i=0; i < addProductsSize; i++) {
            productImageCatalog.get(i).click();
            for (int j = 0; j < random.nextInt(9); j++) {
                productPlusButtonCatalog.get(i).click();
                count ++;
            }
        }
    }

    public String getProductsAddedCounter(){
        String counter = Integer.toString(count);
        return counter;
    }
}