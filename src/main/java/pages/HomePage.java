package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(css = ".ico-login")
    WebElement loginLink;

    @FindBy(className = "ico-account")
    WebElement accountLink;



    public void clickRigisterPage(){

        clickButton(registerLink);

    }

    public void clickLoginPage(){

        clickButton(loginLink);
    }
    public void clickAccountPage(){
        clickButton(accountLink);
    }




}
