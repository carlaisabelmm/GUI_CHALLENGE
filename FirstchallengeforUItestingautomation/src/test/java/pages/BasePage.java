package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.WindowEvent;

public class BasePage {
    static final int WAIT = 5;
    WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitLoadInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }


    public void waitLoadClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitToBeVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement getPageLoader () {
        WebElement pageLoader = driver.findElement(By.className("page-loader"));
        return pageLoader;
    }

    public static void waitToAler(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.alertIsPresent());
    }

}
