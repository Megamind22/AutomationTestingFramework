package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;
    public JavascriptExecutor jse;
    public PageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    protected void clickButton(WebElement element){
        element.click();
    }

    protected void setTextElement(WebElement element ,String text){
        element.sendKeys(text);
    }
    public void clearTextBox(WebElement element) {
        element.clear();
    }

    protected void hoverAndClick(WebElement element) {
        action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }

    //an explicit Wait method to wait for element to be visible
    protected WebElement waitForElementToBeVisible(WebElement webElement) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected WebElement handleElementIsNotClickable(By locator) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class, ElementClickInterceptedException.class);

        return wait.until(driver -> driver.findElement(locator));
    }

    protected boolean inVisibilityOf(WebElement locator) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(TimeoutException.class)
                .until(ExpectedConditions.invisibilityOf(locator));
    }

    protected void JSEClick(WebElement e){
        jse=(JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click",e);

    }

    //an explicit Wait method to wait for element to be clickable
    protected WebElement waitForElementToBeClickable(WebElement webElement) {
        wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

}
